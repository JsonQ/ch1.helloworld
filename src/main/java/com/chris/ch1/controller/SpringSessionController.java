package com.chris.ch1.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SpringSessionController {

    Log log = LogFactory.getLog(SpringSessionController.class);

    @RequestMapping("/putsession.html")
    @ResponseBody
    public String putSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info(session.getId());
        log.info(session.getClass());
        String name = "Chris";
        session.setAttribute("user", name);
        return "hey, " + name;
    }
}
