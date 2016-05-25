package me.codaline.controller;

import me.codaline.helpers.C;
import me.codaline.model.AuthModel;
import me.codaline.service.UserService;
import me.codaline.service.CookieAvailable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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

    private static final Logger logger = LoggerFactory
            .getLogger(EditProfileController.class);

    /**
     * Upload single file using Spring Controller
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFileHandler(HttpServletRequest request, ModelMap modelMap,
            @RequestParam("file") MultipartFile file,
            @RequestParam("userImageId") int userId
    ) {
        String name = userId + ".jpg";

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                File dir = new File(C.PATH_PHOTO);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                service.updatePhoto(userId, "avatar/" + name);
                return editProfile(request, modelMap);
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }

}
