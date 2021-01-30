package com.jaeeunyoo.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().disable()
                    .formLogin().disable()
                    .csrf().disable()
                    .logout().disable()
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
                                                          "/github",
                                                          "/error",
                                                          "/login",
                                                          "/login/**",
                                                          "/auth/**",
                                                          "/loginSuccess",
                                                          "/loginFailure",
                                                          "/oauth2/**",
                                                          "/actuator/health"
                                                          )
                                             .permitAll()
                                             .anyRequest()
                                             .authenticated())
                    .oauth2Login();
    }
}