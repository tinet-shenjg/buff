package com.shenjg.admin.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @ApiOperation(value="获取用户名", notes="不要乱用")
    @GetMapping("/getUser")
    public String getUser(String username){
        logger.info("获取用户名" + username);
        return username;
    }



}