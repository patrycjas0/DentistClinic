package pl.psipko.DentistClinic.domain.repository;
import pl.psipko.DentistClinic.domain.Patient;

import java.time.LocalDate;


public interface PatientRepository {


    void createPatient(String name, String lastname, String email, String password, LocalDate birthDate, int phoneNumber);

   // Collection<Patient> getAllPatient();

    //void deletePatient(Integer id);


    void createPatient(Patient patient);

   // Patient getPatientById(Integer id);


 //   default void updatePatient(int id, Patient patient) { throw new UnsupportedOperationException(); }
}



