package pl.psipko.DentistClinic.domain.repository;


import org.springframework.stereotype.Repository;
import pl.psipko.DentistClinic.domain.Visit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class VisitRepository {

    @PersistenceContext
    EntityManager em;


   @Transactional
    public void createVisit(Visit visit)
    {
        visit=new Visit(visit.getDate(),visit.getTime(),visit.getDescripton(),visit.getDoctor(),visit.getPatient());
        em.persist(visit);
    }
}
