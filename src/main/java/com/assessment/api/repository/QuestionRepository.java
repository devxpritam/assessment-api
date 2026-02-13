package com.assessment.api.repository;


import com.assessment.api.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Find questions belonging to a specific assessment
    List<Question> findByAssessmentId(Long assessmentId);
}
