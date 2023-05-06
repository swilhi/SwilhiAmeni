package com.exam.swilhiameni.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMedecin;
    String nomMedecin;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    Integer telephone;
    Integer prixConsultation;
    @OneToMany(mappedBy = "medecin", cascade = CascadeType.PERSIST)
    private Set<RendezVous> rendezVous = new LinkedHashSet<>();
    @ManyToMany(mappedBy = "medecin",cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Clinique> cliniques = new LinkedHashSet<>();
}
