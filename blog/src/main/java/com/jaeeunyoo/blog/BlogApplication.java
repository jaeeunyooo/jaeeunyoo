package com.jaeeunyoo.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BlogApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
