package com.shenjg.base.controller;


import com.shenjg.base.api.LogApi;
import com.shenjg.base.entity.AdminUser;
import com.shenjg.base.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjg
 * @date 2018/12/27
 **/
@RestController
public class LogApiController implements LogApi {

    @Autowired
    private LogService logService;

    @Override
    public String test(String name) {
        return name + "就是我";
    }

    @Override
    public AdminUser users() {
        AdminUser adminUser = logService.getAdminUser();
        return adminUser;
    }
}
