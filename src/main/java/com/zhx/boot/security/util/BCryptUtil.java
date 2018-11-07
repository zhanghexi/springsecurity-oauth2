package com.zhx.boot.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhx
 * @create 2018/11/7 23:04
 * @description BCrypt密码加密工具类
 */
public class BCryptUtil {

    public static String getBCryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String bcryptPassword = encoder.encode(password);
        return bcryptPassword;
    }

    public static void main(String[] args) {
        System.out.println(BCryptUtil.getBCryptPassword("123456"));
    }
}