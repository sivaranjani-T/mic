package com.example.quizz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer quizId;
    private  String quizTitle;
    @ElementCollection
    private List<Integer> questions;

}
