package com.arct.hrworker.repositories;

import com.arct.hrworker.entities.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository <Work, Long> {
}
