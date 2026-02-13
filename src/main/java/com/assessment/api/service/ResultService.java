package com.assessment.api.service;


import com.assessment.api.entity.Attempt;
import com.assessment.api.repository.AttemptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final AttemptRepository attemptRepository;

    /**
     * Requirement 6: View ranked candidate results
     * Fetches all attempts for a specific assessment and sorts them by score (Descending)
     */
    public List<Attempt> getRankedResults(Long assessmentId) {
        return attemptRepository.findByAssessmentIdOrderByScoreDesc(assessmentId);
    }
}
