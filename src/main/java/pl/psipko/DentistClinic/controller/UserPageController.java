package pl.psipko.DentistClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.psipko.DentistClinic.domain.Visit;
import pl.psipko.DentistClinic.service.VisitService;


import javax.validation.Valid;

@Controller
public class UserPageController {

  @Autowired
    VisitService service;

    @RequestMapping(value="/userpage")
    public String userpage()
    {
        return "/userpage";
    }

    @RequestMapping(value="/userpage",method = RequestMethod.GET)
    public String createVisit(Model model)
    {
        model.addAttribute("visit",new Visit());
        return "/userpage";
    }

//    @RequestMapping(value = "/userpage", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserName(Patient patient) {
//        return patient.getUser();
//    }

    @RequestMapping(value="/userpage", method = RequestMethod.POST)
    public String saveVisit(@Valid Visit visit, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "/userpage";
        } else {


            service.saveVisit(visit);
            return "/userpage";}


    }

}
