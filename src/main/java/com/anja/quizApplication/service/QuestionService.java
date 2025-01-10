package com.anja.quizApplication.service;

import com.anja.quizApplication.model.Question;
import com.anja.quizApplication.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo repo;

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }


    public List<Question> getQuestionsByCategory(String category) {
        return repo.findAllByCategory(category);
    }

    public String addQuestion(Question question) {
        Question question1 = repo.save(question);
        if(question1!=null){
            return "Success";
        }else
            return "Fail";
    }
}
