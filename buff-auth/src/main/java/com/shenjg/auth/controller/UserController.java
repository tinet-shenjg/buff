package com.shenjg.auth.controller;

import com.shenjg.core.data.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 *
 * @author shenjg
 * @date 2018/12/05
 **/
@RestController
public class UserController {

    @GetMapping("/user")
    public ResponseModel get(){
        return new ResponseModel(HttpStatus.OK, "hello");
    }

}
