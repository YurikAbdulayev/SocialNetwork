package me.codaline.controller;

import me.codaline.model.AuthModel;
import me.codaline.service.CookieAvailable;
import me.codaline.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @Autowired
    AuthService service;

    @RequestMapping("/")
    String index(HttpServletRequest request, ModelMap modelMap) throws NullPointerException {
        try {
            AuthModel returned = CookieAvailable.getCookie("index", request, modelMap, service);
            return !returned.getJsp().isEmpty() ? returned.getJsp() : "auth";
        }catch (Exception e){
            return "auth";
        }
    }
}
