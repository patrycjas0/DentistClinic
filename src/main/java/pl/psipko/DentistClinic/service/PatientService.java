package pl.psipko.DentistClinic.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.psipko.DentistClinic.domain.Patient;
import pl.psipko.DentistClinic.domain.UserDao;
import pl.psipko.DentistClinic.domain.repository.PatientRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    UserDao userDao;

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientRepository.getAllPatients());
    }


    public Patient findByUser(String user) {


        return  userDao.findByUser(user);
    }

    public void savePatient(Patient patient) {

        patientRepository.createPatient(patient);
    }


//    public Patient getPatient(Integer id) {
//        return patientRepository.getPatientById(id);
//    }
//
//    public void deletePatient(Integer id) {
//        patientRepository.deletePatient(id);
//    }

//    public void updatePatient(Patient patient) {
//        patientRepository.updatePatient(patient.getId(), patient);
//    }

}
