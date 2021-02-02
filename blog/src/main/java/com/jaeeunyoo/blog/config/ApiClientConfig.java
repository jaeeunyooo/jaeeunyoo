package com.jaeeunyoo.blog.config;

import com.jaeeunyoo.blog.client.ToastImageClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ApiClientConfig {

    @Value("${appKey}")
    private String appKey;

    @Value("${secretKey}")
    private String secretKey;

    @Bean
    public ToastImageClient toastImageClient() {
        return new ToastImageClient(appKey, secretKey, new RestTemplate());
    }
}
