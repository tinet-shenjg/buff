package com.shenjg.admin.plugin;

import com.shenjg.admin.configuration.DynamicDataSourceHolder;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 动态数据源配置插件
 *
 * @author shenjg
 * @date 2018/12/25
 **/
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class }) })
public class DynamicDataSourcePlugin implements Interceptor {

        /**
         * 匹配SQL语句的正则表达式
         */
        private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";

        /**
         * 这个map用于存放已经执行过的sql语句所对应的数据源
         */
        private static final Map<String, String> cacheMap = new ConcurrentHashMap<>();

        @Override
        public Object intercept(Invocation invocation) throws Throwable {
            //获取当前事务同步性进行判断
            boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
            //如果当前正在使用事务，则使用默认的库
            if (synchronizationActive) {
                return invocation.proceed();
            }

            //从代理类参数中获取参数
            Object[] objects = invocation.getArgs();
            //其中参数的第一个值为执行的sql语句
            MappedStatement ms = (MappedStatement) objects[0];

            //当前sql语句所应该使用的数据源，通过sql语句的id从map中获取，如果获取到，则之前已经执行过直接取，
            String dynamicDataSourceGlobal = cacheMap.get(ms.getId());
            if (dynamicDataSourceGlobal != null) {
                DynamicDataSourceHolder.putDataSource(dynamicDataSourceGlobal);
                return invocation.proceed();
            }

            //如果没有，则重新进行存放
            //ms中获取方法，如果是查询方法
            if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
                //!selectKey 为自增id查询主键(SELECT LAST_INSERT_ID() )方法，使用主库
                if(ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                    dynamicDataSourceGlobal = "master";
                } else {
                    BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                    //通过正则表达式匹配，确定使用那一个数据源
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                    if(sql.matches(REGEX)) {
                        dynamicDataSourceGlobal = "master";
                    } else {
                        dynamicDataSourceGlobal = "slave";
                    }
                }
            } else {
                dynamicDataSourceGlobal = "master";
            }
            //将sql对应使用的数据源放进map中存放
            cacheMap.put(ms.getId(), dynamicDataSourceGlobal);

            //最后设置使用的数据源
            DynamicDataSourceHolder.putDataSource(dynamicDataSourceGlobal);

            //执行代理之后的方法
            return invocation.proceed();
        }

        @Override
        public Object plugin(Object target) {
            if (target instanceof Executor) {
                return Plugin.wrap(target, this);
            } else {
                return target;
            }
        }

        @Override
        public void setProperties(Properties properties) {
        }
}



