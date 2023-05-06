package com.exam.swilhiameni.services;

import com.exam.swilhiameni.entities.Clinique;
import com.exam.swilhiameni.entities.Medecin;
import com.exam.swilhiameni.entities.Patient;
import com.exam.swilhiameni.entities.RendezVous;

import java.util.Date;

public interface IService {
    public Clinique addClinique(Clinique clinique);
    public Medecin addMedecinAndAssignToClinique(Medecin medecin,Long cliniqueid);
    public Patient addPatient(Patient patient);
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPtient);
//    int getNbrRendezVousMedecin(Long idMedecin);
    RendezVous retrieveRendezVous(Long idRDV);
    public void retrieveRendezVous();
    public int getRevenuMedecin(Long idMedecin, Date start, Date end);
}
