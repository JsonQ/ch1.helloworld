package com.chris.ch1.configurer;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnBean(RedisTemplate.class)
@ConditionalOnMissingBean(CacheManager.class)
//@Conditional(CacheCondition.class)
public class RedisCacheConfig {

//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(getConfigutation());
//        List<String> cacheNames = this.cacheProperties.getCacheNames();
//        if(!cacheNames.isEmpty()){
//            builder.initialCacheNames(new LinkedHashSet<>(cacheNames));
//        }
//
//        return this.customizerInvoker.customize(builder.build());
//    }
}
//
//interface CacheManager{
//    Cache getCache(String name);
//    Collection<String> getCacheNames();
//}
