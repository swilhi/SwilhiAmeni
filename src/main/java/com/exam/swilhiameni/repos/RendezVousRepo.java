package com.exam.swilhiameni.repos;

import com.exam.swilhiameni.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {
    void retrieveRendezVous();
}
