package com.zhx.boot.security.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhx
 * @date 2018/11/1 18:10
 * @description
 */
@Log4j2
@Controller
public class LoginController {

    /**
     * 登录成功后跳转授权页
     *
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 登录失败后的返回页
     *
     * @return
     */
    @GetMapping(value = "login/error")
    public String loginError() {
        return "error";
    }
}