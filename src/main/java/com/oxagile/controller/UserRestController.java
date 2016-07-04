package com.oxagile.controller;

import com.oxagile.model.dto.UserDTO;
import com.oxagile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }


    @RequestMapping(value = "/users/department/{departmentName}", method = RequestMethod.GET)
    public List<UserDTO> getUsersByDepartment(@PathVariable String departmentName) {
        return userService.findUsersByDepartment(departmentName);
    }

    @RequestMapping(value = "/synchronize", method = RequestMethod.GET)
    public List<UserDTO> updateUsers() {
        userService.synchronizeLdapAndDb();
        return userService.getAllUsers();
    }
}
