package me.codaline.controller;

import me.codaline.helpers.C;
import me.codaline.model.AuthModel;
import me.codaline.model.User;
import me.codaline.service.UserService;
import me.codaline.service.CookieAvailable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yurik on 21.05.16.
 */
@Controller
public class EditProfileController {

    @Autowired
    UserService service;

    AuthModel returned;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    String editProfile(HttpServletRequest request, ModelMap modelMap) {
        returned = CookieAvailable.getCookie("editProfile", request, modelMap, service);
        return returned.getJsp().isEmpty() ? "auth" : returned.getJsp();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    String saveProfile(ModelMap modelMap,
                       @RequestParam(value = "e_name") String name,
                       @RequestParam(value = "e_surname") String surname,
                       @RequestParam(value = "e_nick") String nick,
                       @RequestParam(value = "e_birth") String birth,
                       @RequestParam(value = "e_mail") String mail,
                       @RequestParam(value = "e_pass") String pass,
                       @RequestParam(value = "e_city") String city,
                       @RequestParam(value = "e_phone") String phone,
                       @RequestParam(value = "e_interests") String interests,
                       @RequestParam(value = "e_citations") String citations,
                       @RequestParam(value = "e_about") String about,
                       @RequestParam(value = "e_hobby") String hobby,
                       @RequestParam(value = "e_books") String books,
                       @RequestParam(value = "e_films") String films
    ) {
        service.updateUser(name, surname, nick, birth, mail, pass, city, phone, interests, citations, about, hobby,
                books, films, returned.getUser(), returned.getUser().getId());
        modelMap.addAttribute("user", returned.getUser());

        return "editProfile";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFileHandler(HttpServletRequest request, ModelMap modelMap,
                                    @RequestParam("file") MultipartFile file,
                                    @RequestParam("userImageId") int userId
    ) {
        String name = userId + ".jpg";

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                service.updatePhoto(bytes, userId);

                return editProfile(request, modelMap);

            } catch (Exception e) {
                return "err";
            }
        } else {
//            return "You failed to upload " + name
//                    + " because the file was empty.";
        }
        return "success";
    }

    @RequestMapping(value = "/getImg", method = RequestMethod.GET)
    void getImage(@RequestParam(value = "id") int id, HttpServletResponse response, HttpServletRequest request) throws IOException {

        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(service.getImage(id).getImage());
        response.getOutputStream().close();
    }

}
