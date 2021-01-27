package com.jaeeunyoo.blog.config;

import com.jaeeunyoo.blog.BlogApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = { BlogApplication.class })
@EnableJpaRepositories(basePackageClasses = { BlogApplication.class })
public class JpaConfig {

}
