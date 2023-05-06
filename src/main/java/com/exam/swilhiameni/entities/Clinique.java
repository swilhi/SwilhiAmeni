package com.exam.swilhiameni.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClinique;
    String nomClinique;
    String addresse;
    Integer telephone;
    @ManyToMany
    private Set<Medecin> medecin;
}
