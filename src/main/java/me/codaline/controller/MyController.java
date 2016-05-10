package me.codaline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    boolean authorized = true;

    @RequestMapping("/")
    String index() {
        if (authorized){
            return "index";
        }else {
            return "auth";
        }
    }
}
