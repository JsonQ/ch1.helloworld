package com.chris.ch1.controller;

import com.chris.ch1.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/rest")
public class RestClientTestController {

    @Value(value="${api.order}")
    private String base;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/getObject/{orderId}")
    @ResponseBody
    public Order testGetOrderObject(@PathVariable String orderId) throws Exception{

        RestTemplate client = restTemplateBuilder.build();
        String uri = base + "/order/{orderId}";

        Order order = client.getForObject(uri, Order.class, orderId);
        return order;
    }

    @GetMapping("/getEntity/{orderId}")
    @ResponseBody
    public String testGetOrderEntity(@PathVariable String orderId) throws Exception{

        RestTemplate client = restTemplateBuilder.build();
        String uri = base + "/order/{orderId}";

        ResponseEntity<Order> orderEntity = client.getForEntity(uri, Order.class, orderId);
        Order order = orderEntity.getBody();
        HttpHeaders headers = orderEntity.getHeaders();

        return "success\n";
    }
}
