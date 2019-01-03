package pl.psipko.DentistClinic.domain.repository;

import org.springframework.data.repository.Repository;
import pl.psipko.DentistClinic.domain.Patient;

public interface UserDao extends Repository<Patient,String> {

    Patient findByUser(String user);
}
