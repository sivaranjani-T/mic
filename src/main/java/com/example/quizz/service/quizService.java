package com.example.quizz.service;


import com.example.quizz.DAO.QuizRepository;

import com.example.quizz.model.QuestionWrapper;
import com.example.quizz.DTO.QuizDTO;
import com.example.quizz.feign.QuizFeign;

import com.example.quizz.model.Quiz;
import com.example.quizz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService implements QuizService{

    @Autowired
    QuizRepository quizRepository;
   @Autowired
   QuizFeign quizFeign;
    @Override
    public ResponseEntity<String> createQuizService(QuizDTO quizDTO) {
        List<Integer> question=quizFeign.generateQuestion(quizDTO.getCategoryName(),quizDTO.getNoOfNum()).getBody();
        Quiz  quiz=new Quiz();
        quiz.setQuizTitle(quizDTO.getTitle());
        quiz.setQuestions(question);
        quizRepository.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> displayQuiz(Integer id) {
       Quiz quiz=quizRepository.findById(id).get();
       List<Integer> questionId=quiz.getQuestions();
        List<QuestionWrapper> questionWrappers=quizFeign.getQuestion(questionId).getBody();

    return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {


    return  quizFeign.getScore(responses);
    }
}
