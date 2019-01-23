package com.shenjg.auth.controller;

import com.shenjg.auth.api.AdminUserApi;
import com.shenjg.auth.entity.AdminUser;
import com.shenjg.auth.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * adminuserApi实现
 *
 * @author shenjg
 * @date 2019/01/23
 **/
@RestController
public class AdminUserApiController implements AdminUserApi{

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public AdminUser getByUsername(String username) {
        return adminUserService.getByUsername(username);
    }

    @Override
    public AdminUser getByAdminUser(AdminUser adminUser) {
        return adminUserService.getByAdminUser(adminUser);
    }
}
