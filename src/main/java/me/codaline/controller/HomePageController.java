package me.codaline.controller;

import me.codaline.model.AuthModel;
import me.codaline.service.CookieAvailable;
import me.codaline.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomePageController {

    @Autowired
    AuthService service;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String index(HttpServletRequest request, ModelMap modelMap) throws NullPointerException {
        AuthModel returned = CookieAvailable.getCookie("index", request, modelMap, service);
        return returned.getJsp().isEmpty() ? "auth" : returned.getJsp();
    }


}
