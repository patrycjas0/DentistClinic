package pl.psipko.DentistClinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.psipko.DentistClinic.domain.repository.PatientRepository;
import pl.psipko.DentistClinic.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    PatientService service;

    @RequestMapping(value="/lo")
    public String lo()
    {
      //  service.createAdmin();

        return "/lo";
    }

    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        String role =  authResult.getAuthorities().toString();

        if(role.contains("ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/all-patient"));
        }
        else if(role.contains("USER")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/userpage"));
        }
    }

}