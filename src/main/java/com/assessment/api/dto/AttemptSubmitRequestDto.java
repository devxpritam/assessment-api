package com.assessment.api.dto;

import lombok.Data;
import java.util.Map;

@Data
public class AttemptSubmitRequestDto {
    // Map of QuestionID -> SelectedOption (e.g., {1: "A", 2: "C"})
    private Map<Long, String> answers;
}