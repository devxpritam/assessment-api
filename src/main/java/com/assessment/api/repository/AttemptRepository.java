package com.assessment.api.repository;
import com.assessment.api.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {
    // Requirement 6: View ranked candidate results (descending)
	List<Attempt> findByAssessmentIdOrderByScoreDesc(Long assessmentId);
	}