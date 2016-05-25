package me.codaline.helpers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static me.codaline.helpers.C.USER_ID;

/**
 * Created by yurik on 24.05.16.
 */
public class Utils {

    public static String getMyId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(USER_ID)){
                return cookie.getValue();
            }
        }
        return null;
    }
}
