package com.shenjg.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 *
 * @author shenjg
 * @date 2018/11/01
 */
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    @GetMapping("/getUser")
    public String getUser(String username){
        return username;
    }


}