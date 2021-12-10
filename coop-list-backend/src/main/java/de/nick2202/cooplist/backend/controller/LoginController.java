package de.nick2202.cooplist.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(path = "/login")
public class LoginController {

//    @RequestMapping(value = "/login.html", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView login() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }

//    @RequestMapping({ "/index", "/" })
//    public String index() {
//        return "index";
//    }

//    @Autowired
//    LoginService loginService;


//    @RequestMapping(value = "/loginBewohner", method = {RequestMethod.GET, RequestMethod.POST})
//    public BewohnerDto registerBewohner(@ModelAttribute("bewohnerDto") BewohnerDto bewohnerDto) throws BusinessException {
//        loginService.validateUser(bewohnerDto.getBenutzername(), bewohnerDto.getPassword());
//
//        return bewohnerDto;
//
//    }


//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String showLoginPage(ModelMap model){
//        return "login";
//    }
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
//        boolean isValidUser = service.validateUser(name, password);
//        if (!isValidUser) {
//            model.put("errorMessage", "Invalid Credentials");
//            return "login";
//        }
//        model.put("name", name);
//        model.put("password", password);
//        return "welcome";
//    }
}
