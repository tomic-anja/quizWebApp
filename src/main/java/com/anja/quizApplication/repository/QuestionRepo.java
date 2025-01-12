package com.anja.quizApplication.repository;

import com.anja.quizApplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findAllByCategory(String category);

    @Query(value = "SELECT * " +
            "FROM question q " +
            "WHERE q.category = :category " +
            "ORDER BY RANDOM() " +
            "LIMIT :i", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int i);
}
