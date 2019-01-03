package pl.psipko.DentistClinic.domain.repository;

import pl.psipko.DentistClinic.domain.Patient;


public interface PatientRepository {


    //void createPatient(String name, String lastname, String user, String password, LocalDate birthDate, int phoneNumber,String role);

   // Collection<Patient> getAllPatient();

    //void deletePatient(Integer id);

    void createPatient(Patient patient);

   // Patient getPatientById(Integer id);


 //   default void updatePatient(int id, Patient patient) { throw new UnsupportedOperationException(); }
}



