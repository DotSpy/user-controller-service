package com.oxagile.controller;

import com.oxagile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getTestAnalyzer() {
        userService.saveUsersLdap(userService.getAllUsersLdap());
        userService.getAllUsersDb();
        return "authorization";
    }

}
