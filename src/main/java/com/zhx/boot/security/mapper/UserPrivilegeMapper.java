package com.zhx.boot.security.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhx
 * @date 2018/11/29 10:21
 * @description
 */
public interface UserPrivilegeMapper {

    /**
     * 获得用户的权限
     *
     * @param id
     * @return
     */
    List<String> getAuthorities(@Param(value = "id") Integer id);
}
