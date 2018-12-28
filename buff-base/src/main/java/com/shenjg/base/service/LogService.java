package com.shenjg.base.service;

import com.shenjg.base.entity.AdminUser;
import com.shenjg.base.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * logService
 *
 * @author shenjg
 * @date 2018/12/28
 **/
@Service
public class LogService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser getAdminUser(){
        return adminUserMapper.getById(1);
    }
}
