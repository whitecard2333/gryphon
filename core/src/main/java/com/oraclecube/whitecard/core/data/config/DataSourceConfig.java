package com.oraclecube.whitecard.core.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * DataSource configuration
 * Created by zhouhu on 21/4/2017.
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "localDataSourceProperties")
//    @Primary
    @ConfigurationProperties(prefix = "gryphon.core.datasource")
    public LocalDataSourceProperties getLocalDataSourceProperties() {
        return new LocalDataSourceProperties();
    }

    @Bean(name = "localDataSource")
    public DataSource getDataSource(@Qualifier("localDataSourceProperties") LocalDataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setMaxWait(properties.getMaxWaitMillis());
        return dataSource;
    }
}
