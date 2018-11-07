package com.zhx.boot.security.config.oauth2;

import com.zhx.boot.security.constant.Oauth2Constant;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author zhx
 * @date 2018/10/30 16:02
 * @description 用户资源配置
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(Oauth2Constant.RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*post请求往redis增加数据的url配置*/
                .antMatchers("/redis/set*").permitAll()
                .antMatchers(HttpMethod.POST, "/redis/set*").anonymous()
                /*get请求具体数据的url配置*/
                .antMatchers("/redis/get*").permitAll()
                .antMatchers(HttpMethod.GET, "/redis/get*").anonymous()
                .anyRequest().authenticated();
//                .requestMatchers().antMatchers(HttpMethod.POST, "/redis/set*")
//                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/redis/set*").authenticated()
//                .and().requestMatchers().antMatchers(HttpMethod.GET, "/redis/get*")
//                .and().authorizeRequests().antMatchers(HttpMethod.GET, "/redis/get*").authenticated();
    }
}