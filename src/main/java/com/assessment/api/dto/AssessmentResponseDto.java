package com.assessment.api.dto;


import lombok.Data;
import java.util.List;

@Data
public class AssessmentResponseDto {
    private Long id;
    private String title;
    private int duration;
    private int totalMarks;
    private List<QuestionRequestDto> questions; 
}