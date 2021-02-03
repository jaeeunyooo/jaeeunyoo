package com.jaeeunyoo.blog.config;

import com.jaeeunyoo.blog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/sitemap").permitAll()
                    .antMatchers("/post/*").permitAll()
                    .antMatchers("/about").permitAll()
                    .antMatchers("/archive").permitAll()
                    .antMatchers("/category").permitAll()
                    .antMatchers("/category/**").permitAll()
                    .antMatchers("/tag").permitAll()
                    .antMatchers("/tag/**").permitAll()
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/api/post").permitAll()
                    .antMatchers("/api/post/**").permitAll()
                    .antMatchers("/actuator/health").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(memberService);
    }
}