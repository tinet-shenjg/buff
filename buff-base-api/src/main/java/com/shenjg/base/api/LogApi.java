package com.shenjg.base.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shenjg
 * @date 2018/12/27
 **/
@FeignClient(name = "LogApi", url = "${buff.app.buff-base.url}")
public interface LogApi {

    @GetMapping("/LogApi/test")
    String test(@RequestParam("name") String name);
}
