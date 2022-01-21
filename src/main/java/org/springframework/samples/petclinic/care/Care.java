package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Care")
public class Care extends BaseEntity{

    @NotNull
    @Size(min = 5,max = 30)
    @Column(unique = true)
    String name;

    @NotEmpty
    String description;

    @NotEmpty
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "care_pet_type",
		joinColumns = {@JoinColumn(name = "fk_care")},
		inverseJoinColumns = {@JoinColumn(name = "fk_pet")})
    Set<PetType> compatiblePetTypes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "incompatible_care",
		joinColumns = {@JoinColumn(name = "fk_care1")},
		inverseJoinColumns = {@JoinColumn(name = "fk_care2")})
    Set<Care> incompatibleCares;
}
