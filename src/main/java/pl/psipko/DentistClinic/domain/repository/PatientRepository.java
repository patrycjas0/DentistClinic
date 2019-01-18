package pl.psipko.DentistClinic.domain.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import pl.psipko.DentistClinic.domain.Patient;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class PatientRepository{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public void createPatient(Patient patient) {

        String encodedPassword= bCryptPasswordEncoder.encode(patient.getPassword());

        patient= new Patient(patient.getName(),patient.getLastname(),encodedPassword,patient.getUser(),
                patient.getBirthDate(),patient.getPhoneNumber(),patient.getRole(),patient.isEnabled());


        em.persist(patient);
    }

    public Collection<Patient> getAllPatients() {

        return  em.createQuery("from Patient", Patient.class).getResultList();
    }


}


