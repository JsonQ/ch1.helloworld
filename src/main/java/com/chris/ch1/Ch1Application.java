package com.chris.ch1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Ch1Application {

    public static void main(String[] args){
        SpringApplication.run(Ch1Application.class, args);
    }
}
