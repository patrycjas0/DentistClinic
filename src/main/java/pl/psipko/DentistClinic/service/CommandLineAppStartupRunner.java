package pl.psipko.DentistClinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.psipko.DentistClinic.domain.Doctor;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    DoctorService doctorService;

    @Override
    public void run(String...args) throws Exception
    {
        Doctor admin=new Doctor("admin","admin","ADMIN",true);
        doctorService.saveDoctor(admin);

    }
}
