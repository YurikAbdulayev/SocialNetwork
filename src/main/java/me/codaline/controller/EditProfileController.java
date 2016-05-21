package me.codaline.controller;

import me.codaline.model.AuthModel;
import me.codaline.service.AuthService;
import me.codaline.service.CookieAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yurik on 21.05.16.
 */
@Controller
public class EditProfileController {

    @Autowired
    AuthService service;

    AuthModel returned;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    String editProfile(HttpServletRequest request, ModelMap modelMap){
        returned = CookieAvailable.getCookie("editProfile", request, modelMap, service);
        return returned.getJsp().isEmpty() ? "auth" : returned.getJsp();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    String saveProfile(ModelMap modelMap,
            @RequestParam(value = "e_name")String name,
            @RequestParam(value = "e_surname")String surname,
            @RequestParam(value = "e_nick")String nick,
            @RequestParam(value = "e_birth")String birth,
            @RequestParam(value = "e_mail")String mail,
            @RequestParam(value = "e_pass")String pass,
            @RequestParam(value = "e_city")String city,
            @RequestParam(value = "e_phone")String phone,
            @RequestParam(value = "e_interests")String interests,
            @RequestParam(value = "e_citations")String citations,
            @RequestParam(value = "e_about")String about,
            @RequestParam(value = "e_hobby")String hobby,
            @RequestParam(value = "e_books")String books,
            @RequestParam(value = "e_films")String films
    ){
        service.saveUser(name, surname, nick, birth, mail, pass, city, phone, interests, citations, about, hobby,
                books, films, returned.getUser(), returned.getUser().getId());
        modelMap.addAttribute("user", returned.getUser());

        return "editProfile";
    }

}
