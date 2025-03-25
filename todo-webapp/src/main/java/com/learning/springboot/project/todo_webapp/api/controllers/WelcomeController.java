package com.learning.springboot.project.todo_webapp.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("username")
public class WelcomeController {


    private Logger log = LoggerFactory.getLogger(WelcomeController.class);

    // with query-param and passing that to view(jsp) using ModelMap
//    @GetMapping("login")
//    public String getLoginPage(@RequestParam String name, ModelMap model) {
//        model.put("yourName", name);
//        log.info("Request param is "+ name);
//        return "login";
//    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String getWelcomePage(ModelMap model) {
        model.put("username", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
