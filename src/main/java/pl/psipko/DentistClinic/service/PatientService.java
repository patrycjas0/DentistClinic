package pl.psipko.DentistClinic.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.psipko.DentistClinic.domain.Patient;
import pl.psipko.DentistClinic.domain.repository.PatientRepository;

@Component
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

//    public List<Patient> getAllPatient() {
//        return new ArrayList<>(patientRepository.getAllPatient());
//    }


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
