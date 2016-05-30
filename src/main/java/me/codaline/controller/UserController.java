package me.codaline.controller;

import me.codaline.helpers.Utils;
import me.codaline.model.AuthModel;
import me.codaline.model.User;
import me.codaline.model.WallEntry;
import me.codaline.service.CookieAvailable;
import me.codaline.service.UserService;
import me.codaline.service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    WallService wallService;



    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String myHomePage(HttpServletRequest request, ModelMap modelMap) throws NullPointerException {
        AuthModel returned = CookieAvailable.getCookie("index", request, modelMap, service);
        List<WallEntry> entries = wallService.getListWallEntries(returned.getUser().getId());
        List<User> friends = service.getFriends(returned.getUser().getId());
        modelMap.addAttribute("list_friends", friends);
        modelMap.addAttribute("wall_list", entries);
        modelMap.addAttribute("my_id", Utils.getMyId(request));
        return returned.getJsp().isEmpty() ? "auth" : returned.getJsp();
    }

    @RequestMapping(value = "/addEntry", method = RequestMethod.POST)
    public void ajaxTest(@RequestParam ("message") String message,
                         @RequestParam ("userId")int userId,
                         @RequestParam ("writerId") int writerId) {
        WallEntry entry = new WallEntry();
        entry.setMessage(message);
        entry.setWriterId(writerId);
        entry.setCreateDate("10");
        entry.setTitle("yurik");
        entry.setUpdateDate("10");
        entry.setUserId(userId);
        // TODO: 23.05.16  add cookie user id
        wallService.saveEntry(entry);
    }

}
