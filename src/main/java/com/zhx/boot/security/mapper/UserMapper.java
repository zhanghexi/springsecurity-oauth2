package com.zhx.boot.security.mapper;

import com.zhx.boot.security.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhx
 * @date 2018/11/28 18:11
 * @description
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User selectUserByUsername(@Param(value = "username") String username);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAllUsers();
}
