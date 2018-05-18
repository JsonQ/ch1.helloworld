//package com.chris.ch1.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.juli.logging.Log;
//import org.apache.juli.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class ErrorController extends AbstractErrorController {
//
//    Log log = LogFactory.getLog(ErrorController.class);
//    private static final String ERROR_PATH = "/error";
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    public ErrorController(){
//        super(new DefaultErrorAttributes());
//    }
//
//    @Override
//    @RequestMapping(ERROR_PATH)
//    public String getErrorPath() {
////        Map<String, Object> model = Collections.unmodifiableMap(super.getErrorAttributes(request, false));
////        Throwable cause = getCause(request);
////        int status = (Integer)model.get("status");
////        String message = (String)model.get("messages");
////        String errorMessage = getErrorMessage(cause);
////
////        log.info(status + ", " + message, cause);
////        response.setStatus(status);
////
////        if(!isJsonRequest(request)){
////            ModelAndView view = new ModelAndView("/error.btl");
////            view.addAllObjects(model);
////            view.addObject("errorMessage", errorMessage);
////            view.addObject("status", status);
////            view.addObject("cause", cause);
////            return view;
////        }else{
////            Map error = new HashMap();
////            error.put("success", false);
////            error.put("errorMessage", errorMessage);
////            error.put("message", message);
////            WriteJson(response, error);
////            return null;
////        }
//
//        return null;
//    }
//
//    protected Throwable getCause(HttpServletRequest request){
//        Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
//        if(error != null){
//            while(error instanceof ServletException && error.getCause() != null){
//                error = ((ServletException) error).getCause();
//            }
//        }
//        return error;
//    }
//
//    protected String getErrorMessage(Throwable ex){
//        return "server error, connect to admin!";
//    }
//
////    protected String getErrorMessage(Throwable ex){
////        if(ex instanceof YourApplicationExcetpion){
////            return ((YourApplicationException)ex).getMessage();
////        }
////
////        return "server error, connect to admin!";
////    }
//
//    protected boolean isJsonRequest(HttpServletRequest request){
//        String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
//        if(requestUri != null && requestUri.endsWith(".json")){
//            return true;
//        }else{
////            request.getHeader("Accept").contains("application/json");
//            return false;
//        }
//    }
//
//}
