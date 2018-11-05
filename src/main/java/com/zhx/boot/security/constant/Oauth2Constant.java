package com.zhx.boot.security.constant;

/**
 * @author zhx
 * @date 2018/10/30 11:20
 * @description
 */
public class Oauth2Constant {

    /**
     * 固定的写法(跟数据库表oauth_client_details的配置一致)
     */
//    public static final String CLIENT_ID = "redisTokenDemo";
//    public static final String CLIENT_SECRET = "123456";
//
//    public static final String SCOPE = "read";
//
//    public static final String AUTH_TYPE = "authorization_code";
//    public static final String PASSWORD_TYPE = "password";
//    public static final String REFRESH_TYPE = "refresh_token";

    /**
     * 跟数据库里配置的资源id一致
     */
    public static String RESOURCE_ID = "redis-token-test";
}