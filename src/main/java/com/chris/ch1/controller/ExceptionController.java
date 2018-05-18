package com.chris.ch1.controller;

import com.chris.ch1.exception.ChrisException;
import com.chris.ch1.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/exception")
public class ExceptionController {

    @RequestMapping(path="/err")
    public String err() throws Exception{
        throw new Exception("err");
    }

    @RequestMapping(path = "err1")
    public String err1() throws MyException{
        throw new MyException("json error test!");
    }

    @RequestMapping(path = "err2")
    public String err2() throws ChrisException {
        throw new ChrisException("json error test!");
    }
}
