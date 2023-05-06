package com.exam.swilhiameni.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPatient;
    String nomPatient;
    Integer telephone;
    Date dateNaissance;
    @OneToMany(mappedBy = "patients",cascade = CascadeType.PERSIST)
    private Set<RendezVous> rendezVous = new LinkedHashSet<>();
}
