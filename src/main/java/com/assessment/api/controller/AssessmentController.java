package com.assessment.api.controller;


import com.assessment.api.dto.CreateAssessmentRequestDto;
import com.assessment.api.entity.*;
import com.assessment.api.service.AssessmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final AssessmentService assessmentService;

    @PostMapping // API 1: Create new assessment
    public Assessment create(@Valid @RequestBody CreateAssessmentRequestDto dto) {
        return assessmentService.saveAssessment(dto);
    }

    @PostMapping("/{id}/questions") // API 2: Add questions
    public List<Question> addQuestions(@PathVariable Long id, @RequestBody List<Question> questions) {
        return assessmentService.addQuestionsToAssessment(id, questions);
    }

    @GetMapping // API 3: Retrieve all assessments
    public List<Assessment> getAll() {
        return assessmentService.findAll();
    }
}