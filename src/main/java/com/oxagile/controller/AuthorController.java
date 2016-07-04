package com.oxagile.controller;

import com.oxagile.model.dto.UserTokenExample;
import com.oxagile.service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class AuthorController {

    @Autowired
    private AuthorizeService authorizeService;

    @RequestMapping(value = "/authorize", method = RequestMethod.GET)
    public String getTestAnalyzer() {

        return "authorization";
    }

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public String addNewUser(@RequestBody UserTokenExample userTokenExample) {
        authorizeService.getTokenForUser(userTokenExample);
        return "authorization";
    }
}
