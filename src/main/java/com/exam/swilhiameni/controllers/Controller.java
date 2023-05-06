package com.exam.swilhiameni.controllers;

import com.exam.swilhiameni.entities.Clinique;
import com.exam.swilhiameni.entities.Medecin;
import com.exam.swilhiameni.entities.Patient;
import com.exam.swilhiameni.entities.RendezVous;
import com.exam.swilhiameni.services.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller {
    @Autowired
    IService iService;


    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique){
        return iService.addClinique(clinique);
    }
    @PostMapping("/addMedecinAndAssignToClinique/{id}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable("id") Long cliniqueid){
        return iService.addMedecinAndAssignToClinique(medecin, cliniqueid);
    }
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return iService.addPatient(patient);
    }
    @PostMapping("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rendezVous,@PathVariable("idMedecin") Long idMedecin,@PathVariable("idPatient") Long idPatient){
        iService.addRDVAndAssignMedAndPatient(rendezVous, idMedecin, idPatient);
    }
    @GetMapping("/retrieveRendezVous/{id}")
    public RendezVous retrieveRendezVous(@PathVariable("id") Long idRDV){
        return iService.retrieveRendezVous(idRDV);
    }
//    @GetMapping("/getNbrRendezVousMedecin/{id}")
//    public int getNbrRendezVousMedecin(@PathVariable("id") Long idRDV){
//        return iService.getNbrRendezVousMedecin(idRDV);
//    }
}
