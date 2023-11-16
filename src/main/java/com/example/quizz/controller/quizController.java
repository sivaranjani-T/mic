package com.example.quizz.controller;




import com.example.quizz.DTO.QuizDTO;
import com.example.quizz.model.QuestionWrapper;
import com.example.quizz.model.Response;
import com.example.quizz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class quizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuizService(quizDTO);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> displayQuestion(@PathVariable  Integer id){

        return quizService.displayQuiz(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> result(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }


}
