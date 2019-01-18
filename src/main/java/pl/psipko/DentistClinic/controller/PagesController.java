package pl.psipko.DentistClinic.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PagesController {





    @RequestMapping(value = "/userPage")
    public String userPage() {

        return "userPage";
    }

    @RequestMapping(value = "/about")
    public String about() {

        return "about";
    }
    @RequestMapping(value = "/services")
    public String services() {

        return "services";
    }
    @RequestMapping(value = "/doctors")
    public String doctors() {

        return "doctors";
    }
    @RequestMapping(value = "/blog")
    public String blog() {

        return "blog";
    }
    @RequestMapping(value = "/contact")
    public String contact() {

        return "contact";
    }


}
