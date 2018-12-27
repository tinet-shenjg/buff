package com.shenjg.admin.controller;

import com.shenjg.base.api.LogApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign测试
 *
 * @author shenjg
 * @date 2018/12/27
 **/

@RestController
@RequestMapping("/test")
public class FeignTestController {

    @Autowired
    private LogApi logApi;

    @GetMapping("/test")
    public String test(@RequestParam("name") String name){
        return logApi.test(name);
    }
}
