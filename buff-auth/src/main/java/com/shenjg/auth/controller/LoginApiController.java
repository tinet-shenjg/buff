package com.shenjg.auth.controller;

import com.shenjg.auth.api.LoginApi;
import com.shenjg.auth.entity.AdminUser;
import com.shenjg.auth.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录controller
 *
 * @author shenjg
 * @date 2019/01/22
 **/
@RestController
public class LoginApiController implements LoginApi {

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public AdminUser login(@RequestBody AdminUser adminUser) {
        return adminUserService.getByAdminUser(adminUser);
    }
}
