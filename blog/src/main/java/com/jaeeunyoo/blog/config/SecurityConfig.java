package com.jaeeunyoo.blog.config;

import com.jaeeunyoo.blog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

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
                                                          "/authentication/**",
                                                          "/loginSuccess",
                                                          "/loginFailure",
                                                          "/oauth2/**",
                                                          "/actuator/health"
                                                          )
                                             .permitAll()
                                             .anyRequest()
                                             .authenticated())
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(memberService);
    }
}