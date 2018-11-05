package com.zhx.boot.security.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhx
 * @date 2018/10/10 10:33
 * @description requestbody接口测试专用类
 */
@Data
public class UserInfo implements Serializable {

    private String username;
    private String password;
    private Integer age;
    private String gender;
    private String address;
}