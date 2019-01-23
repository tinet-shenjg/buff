package com.shenjg.auth.api;

import com.shenjg.auth.entity.AdminUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户信息api
 *
 * @author shenjg
 * @date 2019/01/23
 **/
@FeignClient(name = "AdminUserApi", url = "${buff.app.buff-auth.url}")
public interface AdminUserApi {

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @GetMapping("/AdminUserApi/getByUsername")
    AdminUser getByUsername(String username);

    /**
     * 根据用户名和密码获取用户信息
     *
     * @param adminUser
     * @return
     */
    @GetMapping("/AdminUserApi/getByAdminUser")
    AdminUser getByAdminUser(AdminUser adminUser);


}
