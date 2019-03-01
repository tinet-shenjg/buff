package com.shenjg.auth.controller;

import com.shenjg.auth.api.AdminUserApi;
import com.shenjg.auth.entity.AdminUser;
import com.shenjg.auth.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * adminUserApi实现
 *
 * @author shenjg
 * @date 2019/01/23
 **/
@RestController
public class AdminUserApiController implements AdminUserApi{

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public AdminUser getByUsername(@RequestParam("username") String username) {
        return adminUserService.getByUsername(username);
    }

    @Override
    public AdminUser getByAdminUser(@RequestBody AdminUser adminUser) {
        return adminUserService.getByAdminUser(adminUser);
    }

    @Override
    public AdminUser save(@RequestBody AdminUser adminUser) {
        return adminUserService.save(adminUser);
    }

    @Override
    public AdminUser update(@RequestBody AdminUser adminUser) {
        return adminUserService.update(adminUser);
    }

    @Override
    public Integer delete(@RequestBody AdminUser adminUser) {
        return null;
    }

    @Override
    public List<AdminUser> list() {
        return adminUserService.list();
    }
}
