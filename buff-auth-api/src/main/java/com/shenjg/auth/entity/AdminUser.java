package com.shenjg.auth.entity;

import lombok.Data;

/**
 * 管理员用户
 *
 * @author shenjg
 * @date 2018/12/25
 **/
@Data
public class AdminUser {

    private Integer id;

    private String username;

    private String password;

}
