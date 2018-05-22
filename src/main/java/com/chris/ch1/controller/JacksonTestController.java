package com.chris.ch1.controller;

import com.chris.ch1.entity.User;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path="/jackson")
public class JacksonTestController {

    @Autowired
    ObjectMapper objectMapper;

    public static final String JSON = "{\"id\":10,\"name\":\"Chris\"}";

    @RequestMapping(path="/now.json")
    @ResponseBody
    public Map datetime(){
        Map map = new HashMap();
        map.put("time", new Date());
        return map;
    }

    @RequestMapping(path="/readtree.json")
    @ResponseBody
    public String readTree() throws IOException {

        JsonNode node = objectMapper.readTree(JSON);
        int id = node.get("id").asInt();
        String name = node.get("name").asText();

        System.out.println("id:" + id + "    " + "name:" + name);
        return "SUCCESS!";
    }

    @RequestMapping(path="/databind.json")
    @ResponseBody
    public String databind()throws Exception{

        User user = objectMapper.readValue(JSON, User.class);
        return "id:" + user.getId() + ", name:" + user.getName();
    }

    @RequestMapping(path="/serialization.json")
    @ResponseBody
    public String serialization() throws Exception {
        User user = new User();
        user.setId(10);
        user.setName("Chris");
        String str = objectMapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping(path="/parse.html")
    @ResponseBody
    public String parser()throws Exception{
        JsonFactory f = objectMapper.getFactory();
        String key = null, value = null;
        JsonParser p = f.createParser(JSON);
        JsonToken token = p.nextToken();
        token = p.nextToken();
        if(token == JsonToken.FIELD_NAME){
            key = p.getCurrentName();
        }
        token = p.nextToken();
        value = p.getValueAsString();
        p.close();
        return key + ", " + value + "\n";
    }

}
