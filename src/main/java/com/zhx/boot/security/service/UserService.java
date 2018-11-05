package com.zhx.boot.security.service;

import com.zhx.boot.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author zhx
 * @date 2018/11/1 17:16
 * @description
 */
public interface UserService extends UserDetailsService {

    User selectUserByUsername(String username);

    List<User> findAllUsers();
}