package pl.psipko.DentistClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.psipko.DentistClinic.domain.Patient;
import pl.psipko.DentistClinic.service.PatientService;

@Controller
public class RegistrationController {

    @Autowired
    PatientService service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createPatient(Model model)
    {
        model.addAttribute("patient",new Patient());
        return ("index");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String savePatient(@ModelAttribute Patient patient, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return ("index");

            service.savePatient(patient);
            return "/index";


    }

}
