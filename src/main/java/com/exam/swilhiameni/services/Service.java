package com.exam.swilhiameni.services;

import com.exam.swilhiameni.entities.Clinique;
import com.exam.swilhiameni.entities.Medecin;
import com.exam.swilhiameni.entities.Patient;
import com.exam.swilhiameni.entities.RendezVous;
import com.exam.swilhiameni.repos.CliniqueRepo;
import com.exam.swilhiameni.repos.MedecinRepo;
import com.exam.swilhiameni.repos.PatientRepo;
import com.exam.swilhiameni.repos.RendezVousRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@org.springframework.stereotype.Service
public class Service implements IService {
    @Autowired
    public CliniqueRepo cliniqueRepo;
    @Autowired
    public MedecinRepo medecinRepo;
    @Autowired
    public PatientRepo patientRepo;
    @Autowired
    public RendezVousRepo rendezVousRepo;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepo.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin,Long cliniqueid) {
        Clinique clinique = cliniqueRepo.findById(cliniqueid).get();
        medecin.setCliniques((Set<Clinique>) clinique);
        medecinRepo.save(medecin);
        return null;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPtient) {
        Medecin medecin = medecinRepo.findById(idMedecin).get();
        Patient patient = patientRepo.findById(idPtient).get();
        rdv.setMedecin(medecin);
        rdv.setPatients(patient);
        rendezVousRepo.save(rdv);
    }

//    @Override
//    public int getNbrRendezVousMedecin(Long idMedecin) {
//        Medecin medecin = medecinRepo.findById(idMedecin).get();
//        rendezVousRepo.retrieveRendezVous().size();
//    }

    @Override
    public RendezVous retrieveRendezVous(Long idRDV) {
        return rendezVousRepo.findById(idRDV).orElse(null);
    }

    @Override
    @Scheduled(fixedRate = 30000)
    public void retrieveRendezVous() {
        List<RendezVous> list = rendezVousRepo.findAll();
        Date now = new Date();
        for(RendezVous rdv : list){
            if(rdv.getDateRDV().after(now)){
                System.out.println(("La Liste de rdvs: \" +\n" +
                        " rdv.getDateRDV() + \" : \" +\n" +
                        " rdv.getMedecin().getNom() + \" \" +\n" +
                        " rdv.getMedecin().getprenom() + \" :"));
            }
        }

    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date start, Date end) {
            Medecin medecin = medecinRepo.findById(idMedecin).get();
            int count = 0;
            for (RendezVous rdv: medecin.getRendezVous()) {
                if (rdv.getDateRDV().after(start) && rdv.getDateRDV().before(end)) {
                    count++;
                }
            }
            return count * medecin.getPrixConsultation();
        }
    }


