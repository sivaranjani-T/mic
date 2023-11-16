package com.example.question.service;


import com.example.question.model.Question;
import com.example.question.model.QuestionWrapper;
import com.example.question.model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
   ResponseEntity<String> saveQuestion(Question question);

    ResponseEntity<List<Question> >displayQuestion();

   ResponseEntity<List<Question>> displayQuestionByCategory(String category);

    ResponseEntity<List<Integer>> generateQuestionForQuiz(String categoryName, Integer num);

    ResponseEntity<List<QuestionWrapper>> generateQuestionFromId(List<Integer> id);

    ResponseEntity<Integer> generateScore(List<Response> responses);
}
