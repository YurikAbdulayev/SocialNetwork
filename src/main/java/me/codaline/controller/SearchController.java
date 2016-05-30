package me.codaline.controller;

import me.codaline.model.AuthModel;
import me.codaline.model.User;
import me.codaline.service.CookieAvailable;
import me.codaline.service.SearchService;
import me.codaline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yurik on 22.05.16.
 */

@Controller
public class SearchController {

    @Autowired
    UserService userService;

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String serch(ModelMap modelMap, HttpServletRequest request) {
        AuthModel returned = CookieAvailable.getCookie("search", request, modelMap, userService);
//        List<User> users = userService.getUsers();
//        modelMap.addAttribute("users", users);
        return returned.getJsp().isEmpty() ? "auth" : returned.getJsp();

    }

    @RequestMapping(value = "/searchh", method = RequestMethod.GET)
    String searchInLine(ModelMap modelMap, HttpServletRequest request,
                        @RequestParam(value = "line")String search){
        System.out.println(search);
        List<User> users = searchService.searchUsers(search);
        modelMap.addAttribute("s_users", users);
        return "searchUsers";
    }
}
