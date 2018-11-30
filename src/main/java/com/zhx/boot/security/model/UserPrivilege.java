package com.zhx.boot.security.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhx
 * @date 2018/11/2 15:36
 * @description
 */
@Data
public class UserPrivilege implements Serializable {

    private Integer id;

    private String privilege;

    private Integer userId;
}