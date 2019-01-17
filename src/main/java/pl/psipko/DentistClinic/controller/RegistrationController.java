package pl.psipko.DentistClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.psipko.DentistClinic.domain.Patient;
import pl.psipko.DentistClinic.domain.UserDao;
import pl.psipko.DentistClinic.service.PatientService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    PatientService service;


    @RequestMapping(value = "/registration")
    public String registration() {

        return "registration";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createPatient(Model model)
    {
        model.addAttribute("patient",new Patient());
        return ("index");
    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String createPatient2(Model model)
    {
        model.addAttribute("patient",new Patient());
        return ("registration");
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String savePatient(@Valid Patient patient, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "index";
        } else {


            service.savePatient(patient);
            return "/index";}


    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String savePatient2(@Valid Patient patient, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "registration";
        } else {


            service.savePatient(patient);
            return "/lo";}


    }






}
