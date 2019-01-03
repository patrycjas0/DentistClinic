package pl.psipko.DentistClinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"pl.sipko.DentistClinic"})
//@EntityScan("pl.sipko.DentistClinic")
//@EnableJpaRepositories("pl.sipko.DentistClinic")
public class DentistClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentistClinicApplication.class, args);


	}


}
