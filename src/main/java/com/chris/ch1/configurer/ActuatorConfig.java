package com.chris.ch1.configurer;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {

    @ConditionalOnMissingBean(HttpTraceRepository.class)
    @Bean
    public InMemoryHttpTraceRepository traceRepository(){

        InMemoryHttpTraceRepository httpTrace = new InMemoryHttpTraceRepository();
        httpTrace.setCapacity(1);
        return httpTrace;
    }
}
