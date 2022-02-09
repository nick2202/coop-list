package de.nick2202.cooplist.backend.controller;

import de.nick2202.cooplist.backend.exceptions.BusinessException;
import de.nick2202.cooplist.backend.model.AppUser;
import de.nick2202.cooplist.backend.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private AppUserService appUserService;


    @RequestMapping(value = "/registerUser", method = {RequestMethod.GET, RequestMethod.POST})
    public AppUser registerBewohner(AppUser appUser) throws BusinessException {
        appUserService.registerBewohner(appUser);

        return appUser;
    }
}
