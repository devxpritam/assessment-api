package com.assessment.api.service;


import com.assessment.api.dto.CreateAssessmentRequestDto;
import com.assessment.api.entity.*;
import com.assessment.api.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssessmentService {
    private final AssessmentRepository assessmentRepository;
    private final QuestionRepository questionRepository;

    public Assessment saveAssessment(CreateAssessmentRequestDto dto) {
        Assessment assessment = new Assessment();
        assessment.setTitle(dto.getTitle());
        assessment.setDuration(dto.getDuration());
        assessment.setTotalMarks(dto.getTotalMarks());
        return assessmentRepository.save(assessment);
    }

    public List<Question> addQuestionsToAssessment(Long id, List<Question> questions) {
        Assessment assessment = assessmentRepository.findById(id).orElseThrow();
        questions.forEach(q -> q.setAssessment(assessment));
        return questionRepository.saveAll(questions);
    }

    public List<Assessment> findAll() {
        return assessmentRepository.findAll();
    }
}
