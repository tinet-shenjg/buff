package com.shenjg.auth.api;

import com.shenjg.auth.entity.AdminUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 登录Controller
 *
 * @author shenjg
 * @date 2019/01/22
 **/
@FeignClient(name = "LoginApi", url = "${buff.app.buff-auth.url}")
public interface LoginApi {

    @PostMapping("/LoginApi/login")
    AdminUser login(@RequestBody AdminUser adminUser);
}
