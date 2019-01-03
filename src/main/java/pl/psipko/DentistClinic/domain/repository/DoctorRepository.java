package pl.psipko.DentistClinic.domain.repository;

import org.springframework.stereotype.Repository;
import pl.psipko.DentistClinic.domain.Doctor;

@Repository
public interface DoctorRepository {

    void createDoctor(Doctor doctor);
}
