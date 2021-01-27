package com.jaeeunyoo.blog.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    @Value("${databaseUrl}")
    private String databaseUrl;

    @Value("${databaseUserName}")
    private String databaseUserName;

    @Value("${databasePassword}")
    private String databasePassword;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                                .url(databaseUrl)
                                .username(databaseUserName)
                                .password(databasePassword)
                                .driverClassName("com.mysql.jdbc.Driver")
                                .build();
    }
}