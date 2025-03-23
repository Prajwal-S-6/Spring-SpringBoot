package com.learning.springboot.project.todo_webapp.api.controllers;

import com.learning.springboot.project.todo_webapp.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authService;

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    // with query-param and passing that to view(jsp) using ModelMap
//    @GetMapping("login")
//    public String getLoginPage(@RequestParam String name, ModelMap model) {
//        model.put("yourName", name);
//        log.info("Request param is "+ name);
//        return "login";
//    }

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value="login",method= RequestMethod.POST)
    public String goToWelcomePage(@RequestParam(name="name") String userName, @RequestParam(name="password") String userPassword, ModelMap model) {
        if(authService.authenticateUser(userName, userPassword)) {
            return "welcome";
        } else {
            model.put("invalidCred", "Error: Invalid Username or Password");
            return "login";
        }
    }
}
