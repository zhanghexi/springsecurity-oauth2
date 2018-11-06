package com.zhx.boot.security.config.oauth2;

import com.zhx.boot.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * @author zhx
 * @date 2018/10/12 16:21
 * @description Oauth2Server总配置
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2RedisConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 新增的ClientDetailsService注入
     */
    @Autowired
    private ClientDetailsService clientDetailsService;

    /**
     * 新增authorizationCodeServices注入
     */
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    /**
     * 新增UserService注入
     */
    @Autowired
    private UserService userService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authorizationCodeServices(authorizationCodeServices)
                .userDetailsService(userService)
                .authenticationManager(authenticationManager);
    }

    /**
     * 配置token存入redis
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        return redisTokenStore;
    }

    /**
     * 配置oauth2_client_details数据库表元数据的细节
     *
     * @return
     */
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 从数据库里区具体的配置项(加载上面的方法)
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
//        clients.inMemory()
//                //  client_id
//                .withClient(Oauth2Constant.CLIENT_ID)
//                //  client_secret
//                .secret(Oauth2Constant.CLIENT_SECRET)
//                .scopes(Oauth2Constant.SCOPE)
//                .authorizedGrantTypes(Oauth2Constant.AUTH_TYPE, Oauth2Constant.PASSWORD_TYPE,
//                        Oauth2Constant.REFRESH_TYPE)
//                .accessTokenValiditySeconds(1000)
//                .refreshTokenValiditySeconds(1000);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security/*.
                tokenKeyAccess("permitAll()")*/
                /*allow check token*/
                /*.checkTokenAccess("isAuthenticated()")*/
                .realm("springsecurity-oauth2")
                .allowFormAuthenticationForClients();
    }

    /******************************************新增的配置类***************************************************/
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Bean
    public OAuth2RequestFactory oAuth2RequestFactory() {
        return new DefaultOAuth2RequestFactory(clientDetailsService);
    }
}