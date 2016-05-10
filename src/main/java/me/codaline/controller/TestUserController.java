package me.codaline.controller;

import me.codaline.model.TestUser;
import me.codaline.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestUserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    String createUser() {
        return "createUser";
    }

//    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
//         ModelAndView saveUser(
//                    String firstName,
//                    String lastName,
//                    String email
//            ) {
//        ModelAndView modelAndView = new ModelAndView("success");
//        TestUser user = service.createUser(firstName, lastName, email);
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    String saveUser(
            ModelMap modelMap,
            @RequestParam(value = "fName", required = true) String firstName,
            @RequestParam(value = "lName", required = false) String lastName,
            @RequestParam(value = "e", required = true) String email
    ) throws JSONException {
        TestUser testUser = service.createUser(firstName, lastName, email);
        modelMap.addAttribute("testUser", testUser);
        JSONObject jsonObject = new JSONObject();
        if (testUser == null) {
            jsonObject.put("status", false);
        } else {
            jsonObject.put("status", true);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    String getUsers(ModelMap modelMap) {
        List<TestUser> testUsers = service.getUsers();
        modelMap.addAttribute("testUsers", testUsers);
        return "testUsers";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String getUser(ModelMap modelMap, String email) {
        TestUser testUser = service.getUser(email);
        modelMap.addAttribute("testUser", testUser);
        return "testUser";
    }


}
