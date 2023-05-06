package com.exam.swilhiameni.entities;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRDV;
    Date dateRDV;
    String remarque;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Patient patients;
}
