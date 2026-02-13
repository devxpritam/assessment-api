package com.assessment.api.controller;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.api.entity.Attempt;
import com.assessment.api.service.AttemptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attempts")
@RequiredArgsConstructor
public class AttemptController {
    private final AttemptService attemptService;

    @PostMapping("/start") // API 4: Start attempt
    public Attempt start(@RequestParam Long assessmentId, @RequestParam String name, @RequestParam String email) {
        return attemptService.startAttempt(assessmentId, name, email);
    }

    @PostMapping("/{attemptId}/submit") // API 5: Submit and Auto-Calculate
    public Attempt submit(@PathVariable Long attemptId, @RequestBody Map<Long, String> answers) {
        return attemptService.submitAndCalculateScore(attemptId, answers);
    }

    @GetMapping("/all") 
    public List<Attempt> getAll() {
        return attemptService.findAllAttempts();
    }
}
