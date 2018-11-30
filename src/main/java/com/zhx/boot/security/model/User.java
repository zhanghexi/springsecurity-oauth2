package com.zhx.boot.security.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhx
 * @date 2018/11/1 16:58
 * @description
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;
}