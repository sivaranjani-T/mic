package com.example.question.controller;


import com.example.question.model.Question;
import com.example.question.model.QuestionWrapper;
import com.example.question.model.Response;
import com.example.question.service.QuestionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class questionController {
     @Autowired
     QuestionService questionService;
    @PostMapping("save")
    public ResponseEntity<String> saveQuestion(@RequestBody Question question){
      return   questionService.saveQuestion(question);
    }
    @GetMapping("display")
    public ResponseEntity<List<Question>>displayQuestion(){
        return  questionService.displayQuestion();
    }
    @GetMapping("display/category/{category}")
    public ResponseEntity< List<Question>>displayQuestionByCategory(@PathVariable String category){
        return questionService.displayQuestionByCategory(category);
    }
    @GetMapping("generate")
    public  ResponseEntity<List<Integer>> generateQuestion(@RequestParam String categoryName ,@RequestParam Integer num){
        return  questionService.generateQuestionForQuiz(categoryName,num);
    }
    @PostMapping("getQuestion")
    public  ResponseEntity<List<QuestionWrapper>> getQuestion(@RequestBody List<Integer>  id){
        return  questionService.generateQuestionFromId(id);
    }
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return  questionService.generateScore(responses);
    }
}

