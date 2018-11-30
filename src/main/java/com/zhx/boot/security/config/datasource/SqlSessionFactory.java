package com.zhx.boot.security.config.datasource;

import lombok.Data;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zhx
 * @date 2018/11/16 17:00
 * @description
 */
@Data
@Configuration
@ConditionalOnClass(DataSource.class)
public class SqlSessionFactory {

    @Bean
    public SqlSessionFactoryBean oauthSessionFactory(@Qualifier("oauthDataSource")
                                                                DataSource oauthDataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oauthDataSource);
        return sqlSessionFactoryBean;
    }
}