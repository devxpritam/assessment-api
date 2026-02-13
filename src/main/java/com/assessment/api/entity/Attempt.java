package com.assessment.api.entity;


import com.assessment.api.entity.type.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Attempt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String candidateName;
    
    private String candidateEmail;
    
    private int score;
    
    @Enumerated(EnumType.STRING)
    private StatusType status; // STARTED or SUBMITTED

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    @JsonIgnoreProperties({"questions", "attempts"}) 
    private Assessment assessment;
}