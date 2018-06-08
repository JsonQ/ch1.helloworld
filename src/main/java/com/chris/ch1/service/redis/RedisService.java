package com.chris.ch1.service.redis;

public interface RedisService {


    boolean set(String key, String value);

    String get(String key);

    boolean expire(String key, long expire);

    boolean remove(String key);
}
