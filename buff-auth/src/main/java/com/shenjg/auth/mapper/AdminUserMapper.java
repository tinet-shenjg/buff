package com.shenjg.auth.mapper;

import com.shenjg.auth.annotation.TargetDataSource;
import com.shenjg.auth.entity.AdminUser;
import com.shenjg.core.data.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 管理员用户mapper
 *
 * @author shenjg
 * @date 2018/12/25
 **/
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser, Integer>{
    /**
     * 从test1数据源中获取用户信息
     */
    @Select({"<script>",
            "select * from admin_user where id > 0",
            "</script>"})
    AdminUser selectByOddUserId(Integer id);

    /**
     * 从test2数据源中获取用户信息
     */
    @Select({"<script>",
            "select * from admin_user where id > 0",
            "</script>"})
    @TargetDataSource("slave")
    AdminUser getById(Integer id);

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @Select({"<script>",
            "select * from admin_user where username = #{username}",
            "</script>"})
    AdminUser getByUsername(@Param("username") String username);

    AdminUser getByAdminUser(AdminUser adminUser);

    AdminUser save(AdminUser adminUser);
}
