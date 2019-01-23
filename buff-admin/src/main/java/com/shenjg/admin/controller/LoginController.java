package com.shenjg.admin.controller;

import com.shenjg.auth.api.LoginApi;
import com.shenjg.auth.entity.AdminUser;
import com.shenjg.core.data.ResponseModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 用户登录
 *
 * @author shenjg
 * @date 2019/01/23
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginApi loginApi;


    @ApiOperation(value = "登录接口", notes = "不要乱用")
    @PostMapping("/login")
    public ResponseModel login(@RequestParam("username") String userName, @RequestParam("password") String password){
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(userName);
        adminUser.setPassword(password);
        AdminUser loginAdminUser = loginApi.login(adminUser);
        if (Objects.nonNull(loginAdminUser)){
            return new ResponseModel(HttpStatus.OK, "登录成功",loginAdminUser);
        }
        return new ResponseModel(HttpStatus.BAD_REQUEST, "登录失败，用户名或密码错误");
    }

}
