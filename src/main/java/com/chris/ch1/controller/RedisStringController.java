package com.chris.ch1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisStringController {

    @Autowired
    private StringRedisTemplate redisTemp;


    @RequestMapping("/setGet.html")
    @ResponseBody
    public String env(String param){

        try {
            redisTemp.opsForValue().set("testenv", param);
            String str = redisTemp.opsForValue().get("testenv");
            return str;
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/setList.html")
    @ResponseBody
    public String envLIst(String param)throws Exception{
        redisTemp.opsForList().leftPush("platform:message", "hello,world");
        redisTemp.opsForList().leftPush("platform:message", "hello,chris");

        return redisTemp.opsForList().size("platform:message").toString();
    }

    @RequestMapping("/setHash.html")
    @ResponseBody
    public String envHash(String param) throws Exception{
        redisTemp.opsForHash().put("cache", "ip", "192.168.100.242");
        return redisTemp.opsForHash().get("cache", "ip").toString();
    }

    @RequestMapping("/boundKey.html")
    @ResponseBody
    public String boundKey()throws Exception{
        BoundListOperations oprs = redisTemp.boundListOps("someKeys");
        oprs.leftPush("a");
        oprs.leftPush("b");
        return String.valueOf(oprs.size());
    }
}
