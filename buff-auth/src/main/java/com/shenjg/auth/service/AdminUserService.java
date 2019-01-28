package com.shenjg.auth.service;

import com.shenjg.auth.entity.AdminUser;
import com.shenjg.auth.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * adminUserService
 *
 * @author shenjg
 * @date 2019/01/22
 **/
@Service
public class AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser get(AdminUser adminUser){
        return adminUser;
    }

    public AdminUser getByUsername(String username) {
        return adminUserMapper.getByUsername(username);
    }

    public AdminUser getByAdminUser(AdminUser adminUser) {
        return adminUserMapper.getByAdminUser(adminUser);
    }

    public AdminUser save(AdminUser adminUser) {
        return adminUserMapper.save(adminUser);
    }

    public AdminUser update(AdminUser adminUser) {
        return adminUserMapper.update(adminUser);
    }
}
