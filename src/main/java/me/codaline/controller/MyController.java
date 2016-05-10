package me.codaline.controller;

import me.codaline.model.User;
import me.codaline.service.AuthService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    public static final String TOKEN = "token_value";

    private boolean authorized = true;

    @Autowired
    AuthService service;

    @RequestMapping("/")
    String index(HttpServletRequest request, ModelMap modelMap) {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.length);
        for (Cookie c : cookies) {
            if (c.getName().equals(TOKEN)) {
                User user = service.getUser(c.getValue());
                System.out.printf(user.toString());
                modelMap.addAttribute("user", user);
                return "index";
            }
        }
        return "auth";
    }
}
