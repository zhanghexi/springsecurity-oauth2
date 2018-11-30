package com.zhx.boot.security.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author zhx
 * @date 2018/11/16 16:29
 * @description 配置数据库常量类
 */
@Data
@Configuration
public class DataSourceConfig {

    private HikariConfig providerPool;

    @Bean
    @Primary
    @RefreshScope
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource oauthDataSource() {
        return DataSourceBuilder.create().build();
    }
}