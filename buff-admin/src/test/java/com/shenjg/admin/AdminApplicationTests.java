package com.shenjg.admin;

import com.shenjg.admin.entity.AdminUser;
import com.shenjg.admin.mapper.AdminUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AdminApplicationTests.class)
@Slf4j
public class AdminApplicationTests {


    @Autowired
    private AdminUserMapper adminUserMapper;

    @Test
    public void testDynamicDatasource() {
        AdminUser userInfo;
        for (int i = 1; i <= 1; i++) {
            //i为奇数时调用selectByOddUserId方法获取，i为偶数时调用selectByEvenUserId方法获取
            userInfo = i % 2 == 1 ? adminUserMapper.selectByOddUserId(i) : adminUserMapper.getById(i);
            log.info("{}->={}", userInfo.getPassword(), userInfo.getUsername());
        }

    }

}
