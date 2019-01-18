package pl.psipko.DentistClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.psipko.DentistClinic.domain.Patient;
import pl.psipko.DentistClinic.service.PatientService;

import java.awt.*;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    PatientService patientService;

    @RequestMapping(value="/all-patient")
    public String allpatient(){
        return "/all-patient";
    }
    

    @RequestMapping("/all-patient")
    public String getPatients(Model model) {
        List<Patient> allPatients = patientService.getAllPatients();
        model.addAttribute("patients", allPatients);
        return "/all-patient";
    }
}
