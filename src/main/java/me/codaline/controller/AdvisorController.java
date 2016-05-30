package me.codaline.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yurik on 30.05.16.
 */

@ControllerAdvice
public class AdvisorController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String error(){
        return "index";
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "meters/notfound";
    }


    @ExceptionHandler(NullPointerException.class)
    public String nullPointer(HttpServletRequest request, HttpServletResponse response) {
        return new AuthController().logout(request, response);
    }



}
