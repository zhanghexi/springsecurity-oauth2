package com.zhx.boot.security.config.datasource;

import lombok.Data;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhx
 * @date 2018/11/16 16:58
 * @description
 */
@Data
@Configuration
public class MapperScanConfig {

    @Bean
    public MapperScannerConfigurer oauthMapper() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.zhx.boot.security.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("oauthSessionFactory");
        return mapperScannerConfigurer;
    }
}