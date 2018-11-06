package com.zhx.boot.security.config.oauth2;

import com.zhx.boot.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhx
 * @date 2018/11/1 18:07
 * @description
 */
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    /**
     * 新增配置类
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/public/**", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/oauth/authorize", "/oauth/token");
        http.authorizeRequests()
                /*post请求往redis增加数据的url配置*/
                .antMatchers("/redis/set*").permitAll()
                .antMatchers(HttpMethod.POST, "/redis/set*").anonymous()
                /*get请求具体数据的url配置*/
                .antMatchers("/redis/get*").permitAll()
                .antMatchers(HttpMethod.GET, "/redis/get*").anonymous()
                /*get请求登录的url配置*/
                .antMatchers("/login*").permitAll()
                .antMatchers(HttpMethod.GET, "/login*").anonymous()
                .anyRequest().authenticated()

                /*用户登录成功或失败的返回页面*/
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/signin")
                .failureUrl("/login/error")
                /*登录页的用户名、密码name属性*/
                .usernameParameter("username")
                .passwordParameter("password")

                .and()
                .logout()
                .deleteCookies("JSESSIONID")

                .and()
                .exceptionHandling();
        http.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }
}