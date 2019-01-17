package pl.psipko.DentistClinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.psipko.DentistClinic.domain.Visit;
import pl.psipko.DentistClinic.domain.repository.VisitRepository;


@Component
public class VisitService {

   @Autowired
    VisitRepository visitRepository;

    public void saveVisit(Visit visit)
    {
        visitRepository.createVisit(visit);
    }
}
