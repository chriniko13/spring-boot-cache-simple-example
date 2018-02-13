package com.chriniko.example.cachetutorial.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.*;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableCaching
public class CacheConfiguration implements CachingConfigurer {

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        List<ConcurrentMapCache> caches = Collections.singletonList(new ConcurrentMapCache("tickets"));
        cacheManager.setCaches(caches);
        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return new SimpleCacheResolver();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new SimpleCacheErrorHandler();
    }

}
