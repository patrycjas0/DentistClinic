package pl.psipko.DentistClinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.psipko.DentistClinic.domain.Doctor;
import pl.psipko.DentistClinic.domain.repository.DoctorRepository;

@Component
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    public void saveDoctor(Doctor doctor)
    {
        doctorRepository.createDoctor(doctor);
    }
}
