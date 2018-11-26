package pl.psipko.DentistClinic.domain.repository;

import pl.psipko.DentistClinic.domain.Patient;
import pl.psipko.DentistClinic.domain.Visit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

public class DBPatientRepoitory implements PatientRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void createPatient(String name, String lastname, String email, String password, LocalDate birthDate, int phoneNumber) {

        Patient patient = new Patient(name,lastname,email,password,birthDate,phoneNumber);

        em.persist(patient);

    }

    @Override
    @Transactional
    public void createPatient(Patient patient) {
        em.persist(patient);
    }

}

