package org.springframework.samples.petclinic.care;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CareService {    

    @Autowired
    CareProvisionRepository careProvisionRepository;

    public List<Care> getAllCares(){
        return careProvisionRepository.findAllCares();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        //return careProvisionRepository.findCompatibleCares(petTypeName);
        return null;
    }

    public Care getCare(String careName) {
        return careProvisionRepository.findCareByName(careName);
    }

    @Transactional
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        List<CareProvision> caresPerformed=getCaresPerformed(p.getVisit().getId());
        if(!caresPerformed.contains(p)){
            throw new NonCompatibleCaresException();
        }
        return careProvisionRepository.save(p);   
    }

    public List<CareProvision> getCaresPerformed(Integer visitId){
        // careProvisionRepository.findCaresProvidedByVisitId(visitId);
        return null;
    }

    public List<CareProvision> getAllCaresProvided(){
        return careProvisionRepository.findAll();
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return null;

    }
    
}
