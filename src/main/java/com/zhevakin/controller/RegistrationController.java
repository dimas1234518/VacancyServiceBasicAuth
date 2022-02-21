package com.zhevakin.controller;

import com.zhevakin.model.User;
import com.zhevakin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/registrations")
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String check() {
        return "Use POST method";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(@RequestBody User user) throws Exception {

        if (!user.getPassword().endsWith(user.getPasswordConfirm())) {
            throw new Exception("Пароли не совпадают");
        }

        if (!userService.saveUser(user)) {
            throw new Exception("Пользователь с таким именем уже существует");
        }

        return "OK";
    }

}
