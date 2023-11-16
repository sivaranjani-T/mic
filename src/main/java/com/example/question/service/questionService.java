package com.example.question.service;


import com.example.question.DAO.QuestionRepository;
import com.example.question.model.Question;
import com.example.question.model.QuestionWrapper;
import com.example.question.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class questionService implements  QuestionService{
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public ResponseEntity<String> saveQuestion(Question question) {
        try{
            questionRepository.save(question);
         return  new ResponseEntity<>("Success", HttpStatus.CREATED);}
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("not Success",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Question>>displayQuestion() {
        try{
        return  new ResponseEntity<>(questionRepository.findAll(),HttpStatus.OK);}
        catch (Exception e){
           e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> displayQuestionByCategory(String category) {
        try{
        return  new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK);}
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(String categoryName, Integer num) {
        List<Integer> questions=questionRepository.findBycategoryAndRandomNOfQuetions(categoryName,num);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> generateQuestionFromId(List<Integer> id) {
     List<Question>questions=new ArrayList<>();
     List<QuestionWrapper> questionWrappers=new ArrayList<>();
     for(Integer questionid:id){
         questions.add(questionRepository.findById(questionid).get());
     }
     for(Question ques:questions){
         QuestionWrapper wrapper=new QuestionWrapper();
         wrapper.setId(ques.getId());
         wrapper.setQuestionTitle(ques.getQuestionTitle());
         wrapper.setOption1(ques.getOption1());
         wrapper.setOption2(ques.getOption2());
         wrapper.setOption3(ques.getOption3());
         wrapper.setOption4(ques.getOption4());
         questionWrappers.add(wrapper);
     }
     return  new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> generateScore(List<Response> responses) {
        int score=0;
        for(Response res:responses){
            Question question=questionRepository.findById(res.getResponseId()).get();
            if(res.getResponse().equals(question.getRightAnswer())){
                ++score;
            }
        }
        return   new ResponseEntity<>(score,HttpStatus.OK);
    }
}
