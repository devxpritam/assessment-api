package com.assessment.api.service;


import com.assessment.api.entity.*;
import com.assessment.api.entity.type.StatusType;
import com.assessment.api.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttemptService {
    private final AttemptRepository attemptRepository;
    private final AssessmentRepository assessmentRepository;

    public Attempt startAttempt(Long assessmentId, String name, String email) {
        Assessment assessment = assessmentRepository.findById(assessmentId)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));
        
        Attempt attempt = new Attempt();
        attempt.setCandidateName(name);
        attempt.setCandidateEmail(email);
        attempt.setAssessment(assessment);
        attempt.setStatus(StatusType.STARTED);
        return attemptRepository.save(attempt);
    }

    public Attempt submitAndCalculateScore(Long attemptId, Map<Long, String> submittedAnswers) {
        Attempt attempt = attemptRepository.findById(attemptId).orElseThrow();
        Assessment assessment = attempt.getAssessment();
        int finalScore = 0;

        // Scoring Logic: Compare submitted answer with database correctAnswer
        for (Question question : assessment.getQuestions()) {
            String correctAns = question.getCorrectAnswer();
            String submittedAns = submittedAnswers.get(question.getId());

            if (correctAns != null && correctAns.equalsIgnoreCase(submittedAns)) {
                finalScore += question.getMarks();
            }
        }

        attempt.setScore(finalScore);
        attempt.setStatus(StatusType.SUBMITTED);
        return attemptRepository.save(attempt);
    }

	public List<Attempt> findAllAttempts() {
		return attemptRepository.findAll()	;
	}
}