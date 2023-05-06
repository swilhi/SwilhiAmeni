package com.exam.swilhiameni.repos;

import com.exam.swilhiameni.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
}
