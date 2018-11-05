package com.zhx.boot.security.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhx
 * @date 2018/11/2 15:36
 * @description
 */
@Data
@Entity
@Table(name = "user_privilege")
public class UserPrivilege implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "privilege")
    private String privilege;

    @Column(name = "user_id")
    private Integer userId;
}