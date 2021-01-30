package com.jaeeunyoo.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                    .disable()
                    .cors()
                    .and()
                    .authorizeRequests(a -> a.antMatchers("/static/**",
                                                          "/api/**",
                                                          "/",
                                                          "/about",
                                                          "/archive",
                                                          "/post/*",
                                                          "/category",
                                                          "/category/**",
                                                          "/tag",
                                                          "/tag/**",
                                                          "/error",
                                                          "/login",
                                                          "/login/oauth2/code/github"
                                                          )
                                             .permitAll()
                                             .anyRequest()
                                             .authenticated())
                    .oauth2Login();
    }
}