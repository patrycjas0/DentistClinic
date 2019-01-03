package pl.psipko.DentistClinic.domain.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.psipko.DentistClinic.domain.Patient;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class DBPatientRepoitory implements PatientRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void createPatient(Patient patient) {

        String encodedPassword= bCryptPasswordEncoder.encode(patient.getPassword());

        patient= new Patient(patient.getName(),patient.getLastname(),encodedPassword,patient.getUser(),
                patient.getBirthDate(),patient.getPhoneNumber(),patient.getRole(),patient.isEnabled());

        em.persist(patient);
    }

}


