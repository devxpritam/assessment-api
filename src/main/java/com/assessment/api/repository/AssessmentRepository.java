package com.assessment.api.repository;


import com.assessment.api.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    // Standard CRUD operations
}
