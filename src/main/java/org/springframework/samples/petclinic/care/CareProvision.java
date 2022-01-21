package org.springframework.samples.petclinic.care;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CareProvision")
public class CareProvision extends BaseEntity{ 
    
    @NotNull
    @Min(0)
    double duration;

    @ManyToOne(optional = true)
    Visit visit;

    @NotNull
    @ManyToOne(optional = false)
    Care care;   
}
