package me.codaline.controller;

import me.codaline.dao.WallDao;
import me.codaline.helpers.Utils;
import me.codaline.model.AuthModel;
import me.codaline.model.Friends;
import me.codaline.model.User;
import me.codaline.model.WallEntry;
import me.codaline.service.UserService;
import me.codaline.service.CookieAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yurik on 22.05.16.
 */
@Controller
public class FriendsController {

    @Autowired
    UserService service;

    @Autowired
    WallDao wallDao;

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    String getFriends(HttpServletRequest request,
                      @RequestParam(value = "userId")int userId,
                      ModelMap modelMap){
        AuthModel returned = CookieAvailable.getCookie("friends", request, modelMap, service);
        List<User> users = service.getFriends(userId);
        modelMap.addAttribute("friends", users);
        return returned.getJsp().isEmpty() ? "auth" : returned.getJsp();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String getUser(@RequestParam(value = "id")int userId,
                      HttpServletRequest request, ModelMap modelMap){
        User user = service.getUserToId(userId);
        List<WallEntry> entries = wallDao.getEntries(userId);
        List<User> friends = service.getFriends(userId);
        modelMap.addAttribute("list_friends", friends);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("wall_list", entries);
        modelMap.addAttribute("my_id", Utils.getMyId(request));
        modelMap.addAttribute("friend", service.isFriends(Integer.parseInt(Utils.getMyId(request)), userId));
        return "index";
    }

    @RequestMapping(value = "/addToFriend" , method = RequestMethod.POST)
    void addToFriend(
            @RequestParam("friend")int friendId,
            @RequestParam("user")int myId
    ){
        Friends friends = new Friends(myId, friendId);
        service.addToFriend(friends);
    }

    @RequestMapping(value = "/deleteFriend" , method = RequestMethod.POST)
    void deleteFriend(
            @RequestParam("friend")int friendId,
            @RequestParam("user")int myId
    ){
        service.deleteFriends(myId, friendId);
    }
}
