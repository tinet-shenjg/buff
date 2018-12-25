package com.shenjg.admin.configuration;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 实际数据源配置
 *
 * @author shenjg
 * @date 2018/12/25
 **/
@Component
@Data
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {
    private HikariDataSource master;
    private HikariDataSource slave;
}
