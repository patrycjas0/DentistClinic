package pl.psipko.DentistClinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.psipko.DentistClinic.domain.repository.DBPatientRepoitory;
import pl.psipko.DentistClinic.domain.repository.PatientRepository;

@Configuration
public class MainConfig {


    @Bean (name="DBPatientRepository")
    @Profile("prod")
    public PatientRepository createDBRepo() {
        DBPatientRepoitory repo = new DBPatientRepoitory();
        return repo;
    }

}
