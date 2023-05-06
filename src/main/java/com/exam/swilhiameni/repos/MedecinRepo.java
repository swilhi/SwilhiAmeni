package com.exam.swilhiameni.repos;

import com.exam.swilhiameni.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepo extends JpaRepository<Medecin,Long> {
}
