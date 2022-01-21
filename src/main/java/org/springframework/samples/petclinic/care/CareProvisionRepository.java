package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
    @Query("SELECT c FROM Care c")
	List<Care> findAllCares();
    //@Query("SELECT cp FROM Care c JOIN care_pet_type cp WHERE c.name=?1")
    //List<Care> findCompatibleCares(String petTypeName);
    @Query("SELECT c FROM Care c WHERE c.name=?1")
    Care findCareByName(String name);
    //@Query("SELECT cp FROM CareProvision cp JOIN visits v ON cp.visit_id=v.id WHERE v.id=?1")
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
