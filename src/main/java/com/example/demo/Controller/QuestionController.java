package com.example.demo.Controller;

import com.example.demo.Model.Question;
import com.example.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/AllQues")
    public List<Question> AllQuestions() {
        return questionService.AllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> findByCategory(@PathVariable String category) {
        return questionService.findByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
    @DeleteMapping("delete/{id}")
    public void deleteQuestion(@PathVariable int id) {
        questionService.deleteById(id);
    }

    @DeleteMapping("delete/category/{category}")
    public ResponseEntity<String> deleteCategory(@PathVariable String category) {
        questionService.deleteByCategory(category);
        return new ResponseEntity<>("All Questions has been deleted", HttpStatus.OK);
    }
    @GetMapping("get/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }
}
