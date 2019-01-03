package pl.psipko.DentistClinic.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.psipko.DentistClinic.domain.Patient;
import pl.psipko.DentistClinic.domain.repository.PatientRepository;
import pl.psipko.DentistClinic.service.PatientService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserValidatior implements ConstraintValidator<UserUnique,String> {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Override
    public void initialize(UserUnique constraintAnnotation)
    {}

    @Override
    public boolean isValid(String user, ConstraintValidatorContext context)
    {
        if(patientRepository== null)
        {
            return true;
        }

        return patientService.findByUser(user)== null;
    }
}
