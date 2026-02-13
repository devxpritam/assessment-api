package com.assessment.api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String questionText;
    
    private String optionA;
    
    private String optionB;
    
    private String optionC;
    
    private String optionD;
    
    private String correctAnswer; // Stored to compare during submission
    
    private int marks;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    @JsonIgnore 
    private Assessment assessment;
}