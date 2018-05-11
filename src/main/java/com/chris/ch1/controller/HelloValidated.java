package com.chris.ch1.controller;

import com.chris.ch1.entity.logicbean.WorkInfoForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/validated")
public class HelloValidated {

    @RequestMapping(path="/jsr", method=RequestMethod.POST)
    @ResponseBody
    public String jsr( @RequestBody @Validated({WorkInfoForm.Add.class}) WorkInfoForm form, BindingResult brst){

        System.out.println(brst.hasErrors());
        System.out.println(brst.getAllErrors());

        System.out.println(form.getId());
        System.out.println(form.getName());
        System.out.println(form.getEmail());

        if(brst.hasErrors()){
            List<ObjectError> err = brst.getAllErrors();
            for(ObjectError e : err){
                FieldError fe = (FieldError)e;
                System.out.println(fe.getObjectName() + ":" + fe.getField() + ":" + fe.getDefaultMessage());
            }
        }
        return "success";
    }
}