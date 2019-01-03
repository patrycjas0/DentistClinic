package pl.psipko.DentistClinic.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.psipko.DentistClinic.domain.Doctor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class DBDoctorRepository implements DoctorRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public void createDoctor(Doctor doctor) {

        String encodedPassword= bCryptPasswordEncoder.encode(doctor.getPassword());

        doctor= new Doctor(doctor.getEmail(),encodedPassword,doctor.getRole(),doctor.isEnabled());

        em.persist(doctor);
    }
}
