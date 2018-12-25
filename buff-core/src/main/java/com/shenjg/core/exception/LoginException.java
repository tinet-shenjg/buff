package com.shenjg.core.exception;

import com.shenjg.core.enums.ResultEnum;

/**
 * 登陆异常
 *
 * @author shenjg
 * @date 2018/12/18
 **/
public class LoginException extends RuntimeException{
    private String code;

    public LoginException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public LoginException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
