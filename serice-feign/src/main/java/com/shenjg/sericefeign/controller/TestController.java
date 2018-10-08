package com.shenjg.sericefeign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试controller
 *
 * @author shenjg
 * @date 2018/10/08
 */
@FeignClient(value = "admin")
public interface TestController {

    @GetMapping(value = "/test")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}