package com.exam.swilhiameni.repos;

import com.exam.swilhiameni.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliniqueRepo extends JpaRepository<Clinique,Long> {
}
