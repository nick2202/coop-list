package de.nick2202.cooplist.backend.controller;

import de.nick2202.cooplist.backend.service.BenoetigtesProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/einkaufsliste")
public class EinkaufslisteController {

    @Autowired
    private BenoetigtesProduktService benoetigtesProduktService;

//    @RequestMapping(value = "/addBenoetigtesProdukt", method = {RequestMethod.GET, RequestMethod.POST})
//    public BenoetigtesProdukt addBenoetigtesProdukt(@ModelAttribute("produktDto") ProduktDto produktDto) {
//
//        return benoetigtesProduktService.addBenoetigtesProdukt();
//    }


}
