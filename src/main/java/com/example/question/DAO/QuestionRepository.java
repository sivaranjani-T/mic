package com.example.question.DAO;


import com.example.question.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);
    @Query(value = "SELECT q.id FROM question q WHERE q.category =:category ORDER BY RANDOM() LIMIT :qNum",nativeQuery = true)
    List<Integer> findBycategoryAndRandomNOfQuetions(@Param("category") String category, @Param("qNum") int qNum);
}
