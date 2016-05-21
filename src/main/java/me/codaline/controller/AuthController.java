package me.codaline.controller;

import me.codaline.service.CookieAvailable;
import me.codaline.model.User;
import me.codaline.service.AuthService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    @Autowired
    AuthService service;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    String logout (HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals(CookieAvailable.TOKEN)) {
                c.setMaxAge(0);
                c.setValue(null);
                response.addCookie(c);
            }
        }
        return "auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    String saveUser(
            ModelMap modelMap,
            @RequestParam(value = "regLogin", required = true) String login,
            @RequestParam(value = "regEmail", required = true) String email,
            @RequestParam(value = "regPass", required = true) String password,
            @RequestParam(value = "regFName", required = true) String firstName,
            @RequestParam(value = "regLName", required = true) String lastName
    ){
        User user = service.createUser(login, password, email, firstName, lastName);
        return "auth";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    String authUser(ModelMap modelMap, HttpServletResponse response,
            @RequestParam(value = "authLogin", required = true) String login,
            @RequestParam(value = "authPass", required = true) String password
    )throws JSONException{
        User user = service.getUser(login, password);
        if (user != null){
            modelMap.addAttribute("user", user);

            Cookie cookie = new Cookie(CookieAvailable.TOKEN, user.getToken());
            cookie.setMaxAge(365 * 24 * 60 * 60);
            response.addCookie(cookie);
        }
        return "index";
    }


}
