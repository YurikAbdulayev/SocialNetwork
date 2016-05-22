package me.codaline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yurik on 22.05.16.
 */

@Controller
public class SearchController {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    String serch(){

        return "search";
    }
}
