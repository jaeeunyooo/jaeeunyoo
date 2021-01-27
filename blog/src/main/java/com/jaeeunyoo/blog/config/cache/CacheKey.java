package com.jaeeunyoo.blog.config.cache;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheKey {

    public static final int DEFAULT_EXPIRE_SEC = 10;

    public static final String KEY_ALL_POSTS = "allPosts";
    public static final int EXPIRE_SEC_ALL_POSTS = 600;

    public static final String KEY_TRENDING_TAGS = "trendingTags";
    public static final int EXPIRE_SEC_TRENDING_TAGS = 600;
}
