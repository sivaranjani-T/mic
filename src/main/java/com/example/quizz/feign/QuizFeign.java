package com.example.quizz.feign;

import com.example.quizz.model.QuestionWrapper;
import com.example.quizz.model.Response;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("QUESTION-SERVICE")
public interface QuizFeign {
    @GetMapping("api/generate")
    public ResponseEntity<List<Integer>> generateQuestion(@RequestParam String categoryName , @RequestParam Integer num);

    @PostMapping("api/getQuestion")
    public  ResponseEntity<List<QuestionWrapper>> getQuestion(@RequestBody List<Integer>  id);

    @PostMapping("api/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
