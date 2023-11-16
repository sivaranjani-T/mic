package com.example.quizz.service;

import com.example.quizz.model.QuestionWrapper;
import com.example.quizz.DTO.QuizDTO;
import com.example.quizz.model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  QuizService {

    ResponseEntity<String> createQuizService(QuizDTO quizDTO);

    ResponseEntity<List<QuestionWrapper>> displayQuiz(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
