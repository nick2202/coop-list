package de.nick2202.cooplist.backend.controller;

import de.nick2202.cooplist.backend.exceptions.BusinessException;
import de.nick2202.cooplist.backend.model.Bewohner;
import de.nick2202.cooplist.backend.service.BewohnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/bewohner")
public class BewohnerController {

    @Autowired
    private BewohnerService bewohnerService;


    @RequestMapping(value = "/registerBewohner", method = {RequestMethod.GET, RequestMethod.POST})
    public Bewohner registerBewohner(@ModelAttribute("bewohnerDto") Bewohner bewohner) throws BusinessException {
        bewohnerService.registerBewohner(bewohner);

        return bewohner;
    }
}
