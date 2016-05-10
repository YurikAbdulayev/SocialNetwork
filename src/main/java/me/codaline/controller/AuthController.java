package me.codaline.controller;

import me.codaline.model.User;
import me.codaline.service.AuthService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    @Autowired
    AuthService service;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    String createUser() {
        return "auth";
    }

//    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
//         ModelAndView saveUser(
//                    String firstName,
//                    String lastName,
//                    String email
//            ) {
//        ModelAndView modelAndView = new ModelAndView("success");
//        User user = service.createUser(firstName, lastName, email);
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    String saveUser(
            ModelMap modelMap,
            @RequestParam(value = "reglogin", required = true) String login,
            @RequestParam(value = "regemail", required = true) String email,
            @RequestParam(value = "regpass", required = true) String password
    ) throws JSONException {
        User user = service.createUser(login, password, email);
        modelMap.addAttribute("user", user);
        JSONObject jsonObject = new JSONObject();
        if (user == null) {
            jsonObject.put("status", false);
        } else {
            jsonObject.put("status", true);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    String authUser(ModelMap modelMap, HttpServletResponse response,
            @RequestParam(value = "authlogin", required = true) String login,
            @RequestParam(value = "authpass", required = true) String password
    )throws JSONException{
        User user = service.getUser(login, password);
        if (user != null){
            modelMap.addAttribute("user", user);

            Cookie cookie = new Cookie(MyController.TOKEN, user.getToken());
            cookie.setMaxAge(365 * 24 * 60 * 60);
            response.addCookie(cookie);
        }
        return "index";
    }

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    String getUsers(ModelMap modelMap) {
//        List<User> users = service.getUsers();
//        modelMap.addAttribute("users", users);
//        return "users";
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    String getUser(ModelMap modelMap, String email) {
//        User user = service.getUser(email);
//        modelMap.addAttribute("user", user);
//        return "user";
//    }


}
