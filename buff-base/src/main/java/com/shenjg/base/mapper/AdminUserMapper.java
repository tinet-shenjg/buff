package com.shenjg.base.mapper;

import com.shenjg.base.announce.TargetDataSource;
import com.shenjg.base.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 管理员用户mapper
 *
 * @author shenjg
 * @date 2018/12/25
 **/
@Mapper
public interface AdminUserMapper {
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
}
