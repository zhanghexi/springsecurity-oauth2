//package com.zhx.boot.security.config.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
///**
// * @author zhx
// * @date 2018/10/10 10:07
// * @description Redis核心配置类
// */
//@Configuration
//public class RedisConfig {
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate() {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate(redisConnectionFactory);
//        return redisTemplate;
//    }
//}