package me.codaline.service;

import me.codaline.model.AuthModel;
import me.codaline.model.User;
import org.springframework.ui.ModelMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static me.codaline.helpers.C.TOKEN;

/**
 * Created by yurik on 21.05.16.
 */
public class CookieAvailable {


    public static AuthModel getCookie(String s, HttpServletRequest request, ModelMap modelMap, UserService service) {
        AuthModel model = new AuthModel();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(TOKEN)) {
                    User user = service.getUser(c.getValue());
                    model.setUser(user);
                    System.out.printf(user.toString());
                    modelMap.addAttribute("user", user);
                    model.setJsp(s);
                    return model;
                }
            }
        }
        return model;
    }
}
