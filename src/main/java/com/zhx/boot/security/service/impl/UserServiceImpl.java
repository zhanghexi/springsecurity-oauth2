package com.zhx.boot.security.service.impl;

import com.zhx.boot.security.config.CustomUserDetails;
import com.zhx.boot.security.mapper.UserMapper;
import com.zhx.boot.security.mapper.UserPrivilegeMapper;
import com.zhx.boot.security.model.User;
import com.zhx.boot.security.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhx
 * @date 2018/11/1 17:18
 * @description
 */
@Log4j2
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPrivilegeMapper userPrivilegeMapper;

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectUserByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("Could not find the user '" + username + "'");
        } else {
            /*增加用户权限*/
            List<String> authorities = userPrivilegeMapper.getAuthorities(user.getId());
            log.info(user.getUsername() + "的权限:{}", authorities);
            return new CustomUserDetails(user, authorities);
        }
    }
}