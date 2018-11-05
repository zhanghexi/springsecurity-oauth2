package com.zhx.boot.security.controller;

import com.zhx.boot.security.entity.UserInfo;
import com.zhx.boot.security.model.User;
import com.zhx.boot.security.service.UserService;
import com.zhx.boot.security.util.RedisUtil;
import com.zhx.boot.security.util.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhx
 * @date 2018/10/10 10:31
 * @description
 */
@Log4j2
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping(value = "setRedisValue")
    public String setRedisValue(@RequestBody UserInfo userInfo) {
        redisUtil.set("userInfo", userInfo);
        log.info("存入redis后的数据：{}", JsonUtil.convertObj2String(userInfo));
        return userInfo.toString();
    }

    /**
     * 设置过期时间
     *
     * @param userInfo
     * @param expireTime
     * @return
     */
    @PostMapping(value = "setRedisValue/{expireTime}")
    public String setRedisValueByExpireTime(@RequestBody UserInfo userInfo,
                                            @PathVariable(name = "expireTime") long expireTime) {
        redisUtil.set("userInfoByExpireTime", userInfo, expireTime);
        log.info("存入redis后的数据：{}", JsonUtil.convertObj2String(userInfo));
        return userInfo.toString();
    }

    /**
     * 从redis取数据
     *
     * @param key
     * @return
     */
    @GetMapping(value = "getRedisValue/{key}")
    public String getRedisValue(@PathVariable(name = "key") String key) {
        String str = redisUtil.get(key);
        log.info("从redis取出的数据：{}", str);
        return str;
    }

    @GetMapping(value = "findAllUsers")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }
}