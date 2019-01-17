package pl.psipko.DentistClinic.domain;

import org.springframework.data.repository.Repository;



public interface UserDao extends Repository<Patient,String> {


    Patient findByUser(String user);

    void save(Patient patient);
}
