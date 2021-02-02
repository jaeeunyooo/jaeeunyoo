package com.jaeeunyoo.blog.config;

import com.jaeeunyoo.blog.config.cache.CacheKey;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableCaching
@EnableRedisHttpSession
public class RedisCacheConfig {

    @Bean(name = "cacheManager")
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                                                                       .disableCachingNullValues()
                                                                       .entryTtl(Duration.ofSeconds(CacheKey.DEFAULT_EXPIRE_SEC))
                                                                       .computePrefixWith(CacheKeyPrefix.simple())
                                                                       .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));

        Map<String, RedisCacheConfiguration> allPostsCacheConfiguration = new HashMap<>();
        allPostsCacheConfiguration.put(CacheKey.KEY_ALL_POSTS, RedisCacheConfiguration.defaultCacheConfig()
                                                                                      .entryTtl(Duration.ofSeconds(CacheKey.EXPIRE_SEC_ALL_POSTS)));
        Map<String, RedisCacheConfiguration> trendingTagsCacheConfiguration = new HashMap<>();
        trendingTagsCacheConfiguration.put(CacheKey.KEY_TRENDING_TAGS, RedisCacheConfiguration.defaultCacheConfig()
                                                                                              .entryTtl(Duration.ofSeconds(CacheKey.EXPIRE_SEC_TRENDING_TAGS)));

        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory)
                                                         .cacheDefaults(configuration)
                                                         .withInitialCacheConfigurations(allPostsCacheConfiguration)
                                                         .withInitialCacheConfigurations(trendingTagsCacheConfiguration)
                                                         .build();
    }
}