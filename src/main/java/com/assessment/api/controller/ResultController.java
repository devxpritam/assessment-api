package com.assessment.api.controller;

import com.assessment.api.entity.Attempt;
import com.assessment.api.repository.AttemptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {
    private final AttemptRepository attemptRepository;

    @GetMapping("/{assessmentId}") // API 6: Ranked results (Descending)
    public List<Attempt> getResults(@PathVariable Long assessmentId) {
        return attemptRepository.findByAssessmentIdOrderByScoreDesc(assessmentId);
    }
}