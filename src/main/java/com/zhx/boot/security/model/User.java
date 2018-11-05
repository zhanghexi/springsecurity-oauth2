package com.zhx.boot.security.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhx
 * @date 2018/11/1 16:58
 * @description
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}