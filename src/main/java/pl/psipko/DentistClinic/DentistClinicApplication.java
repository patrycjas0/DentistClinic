package pl.psipko.DentistClinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DentistClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentistClinicApplication.class, args);


	}


}
