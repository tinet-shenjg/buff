package com.shenjg.base.controller;

import com.shenjg.base.api.LogApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjg
 * @date 2018/12/27
 **/
@RestController
public class LogApiController implements LogApi {

    @Override
    public String test(String name) {
        return name + "就是我";
    }
}
