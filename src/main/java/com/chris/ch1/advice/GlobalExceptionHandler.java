package com.chris.ch1.advice;

import com.chris.ch1.exception.ChrisException;
import com.chris.ch1.exception.ErrorInfo;
import com.chris.ch1.exception.MyException;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)throws Exception{

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        System.out.println("I am come in.");
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception{

        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());

        return r;
    }

    @ExceptionHandler(value = ChrisException.class)
    public ModelAndView commonErrorHandler(HttpServletRequest req, HttpServletResponse resp, ChrisException e) throws Exception{

        String acc = req.getHeader("Accept");
//        Enumeration<String> accept = req.getHeaders("accetp");
//        accept.
//        String acc = accept.nextElement();

        if(acc.contains("application/json")) {

            ErrorInfo<String> r = new ErrorInfo<String>();
            r.setMessage(e.getMessage());
            r.setCode(ErrorInfo.ERROR);
            r.setUrl(req.getRequestURL().toString());
            writeJson(resp, r);
            return null;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            System.out.println("I am come in.");
            return mav;
        }
    }

    protected void writeJson(HttpServletResponse resp, ErrorInfo<String> errorINfo) throws Exception{
        PrintWriter writer = resp.getWriter();
        writer.print(errorINfo);
        writer.flush();
    }
}
