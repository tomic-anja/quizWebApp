package com.anja.quizApplication.controller;

import com.anja.quizApplication.model.Question;
import com.anja.quizApplication.service.QuestionService;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService service;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return service.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category.toLowerCase());
    }

    @PostMapping("add")
    public String addQuastion(@RequestBody Question question){
        return service.addQuestion(question);
    }

}
