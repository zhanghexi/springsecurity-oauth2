package com.zhx.boot.security.repository;

import com.zhx.boot.security.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhx
 * @date 2018/11/1 17:02
 * @description
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * 登录时查询相关用户存在与否
     * @param username
     * @return
     */
    @Query(value = "select * from user where username = ?", nativeQuery = true)
    User selectUserByUsername(String username);

    /**
     * 根据用户id查询用户权限(user表的id和user_privilege表id相关联)
     *
     * @param id
     * @return
     */
    @Query(value = "select distinct up.privilege from user_privilege up left join user u on up.user_id = :id",
            nativeQuery = true)
    List<String> getAuthorities(@Param(value = "id") Integer id);

    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAllUsers();

}