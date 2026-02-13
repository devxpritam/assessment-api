package com.assessment.api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateAssessmentRequestDto {
    @NotBlank(message = "Title is required")
    private String title;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private int duration;

    @Min(1)
    private int totalMarks;
}
