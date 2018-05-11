package com.chris.ch1.controller;

import com.chris.ch1.entity.Order;
import com.chris.ch1.entity.logicbean.OrderPostForm;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class Hello {
    @RequestMapping("/index.html")
    public String say(Model model){
        model.addAttribute("name", "HelloWorld");
        return "/index.btl";
    }

    @RequestMapping(path="/index.json", consumes="application/json")
    public @ResponseBody Object sayJson(){
        return new String("hello, world!");
    }

    @RequestMapping(path="/update.json", params="action=update")
    @ResponseBody
    public void updateUser(){
        System.out.println("call update.");
    }

    @RequestMapping(path="/save.json", headers="action=save")
    @ResponseBody
    public void saveUser(){
        System.out.println("call save.");
    }

    @RequestMapping(path="/{type}/get.json")
    @ResponseBody
    public void getUser(@PathVariable Long id, @PathVariable Integer type){
        System.out.println("id:" + id + ";" + "type:" + type);
    }

    @RequestMapping(path="/matrixdemo/{type}")
    @ResponseBody
    public void testMatrixVariable(
            @PathVariable Integer type,
            @RequestParam String reqParam//,
//            @MatrixVariable Integer q
            ){
        System.out.println("PathVariable-type:" + type);
        System.out.println("RequestParam-reqParam:" + reqParam);
//        System.out.println("MatrixVariable-matrix:" + q);
    }

//    @RequestMapping(value="/get/{id}.json")
//    public @ResponseBody User getById(@PathVariable("id") Long id){
//        return userService.getUserById(id);
//    }

//    @RequestMapping(path="/all.json", method=RequestMethod.GET)
//    public @ResponseBody List<User> allUser(){
//        return userService.allUser();
//    }
    @ModelAttribute
    public void setUser(Model m){
        m.addAttribute("username", "Chris");
    }

    @RequestMapping(path="/saveOrder", method=RequestMethod.POST)
    @ResponseBody
    public String saveOrder(@RequestBody Order from, Model m){

        System.out.println("order.name:" + from.getName());
        System.out.println("Model contain username:" + m.containsAttribute("username"));
        return "success";
    }

    @RequestMapping(path="/order.html")
    public String viewOrder(){
        return "/order.html";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @RequestMapping(path="bind")
    @ResponseBody
    public void printDate(@RequestParam Date d){
        System.out.println(d);
    }
}
