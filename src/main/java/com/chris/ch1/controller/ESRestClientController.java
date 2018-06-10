package com.chris.ch1.controller;

import com.alibaba.fastjson.JSON;
import com.chris.ch1.entity.Book;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ESRestClientController {

    @RequestMapping("/esclient/book/{id}")
    public String getLogByID(@PathVariable String id)throws Exception{

        RestTemplate template = new RestTemplate();
        Map<String, Object> paras = new HashMap<String, Object>();
        paras.put("id", id);

        String str = template.getForObject("http://localhost:9200/product/book/{id}", String.class, paras);
//        Book book = JSON.parseObject(str, Book.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(str);
        JsonNode root = mapper.readTree(parser);
        JsonNode sourceNOde = root.get("_source");
        Book book = mapper.convertValue(sourceNOde, Book.class);

        return book.getMessage();
    }
}
