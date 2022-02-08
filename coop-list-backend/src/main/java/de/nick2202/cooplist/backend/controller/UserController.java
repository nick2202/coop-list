package de.nick2202.cooplist.backend.controller;

import de.nick2202.cooplist.backend.exceptions.BusinessException;
import de.nick2202.cooplist.backend.model.User;
import de.nick2202.cooplist.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/registerUser", method = {RequestMethod.GET, RequestMethod.POST})
    public User registerBewohner(@ModelAttribute("bewohnerDto") User user) throws BusinessException {
        userService.registerBewohner(user);

        return user;
    }
}
