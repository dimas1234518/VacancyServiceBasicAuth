package com.zhevakin.controller;

import com.zhevakin.model.User;
import com.zhevakin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/admins")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE,
                                MediaType.APPLICATION_XML_VALUE})
    public List<User> userList() {
        return userService.allUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "OK";
    }

    @RequestMapping(method = RequestMethod.GET,
                    value = "{/id}",
                    produces = {MediaType.APPLICATION_XML_VALUE,
                                MediaType.APPLICATION_JSON_VALUE})
    public User getUser(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

}
