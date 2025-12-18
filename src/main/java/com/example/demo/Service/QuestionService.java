package com.example.demo.Service;

import com.example.demo.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Question;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepo.save(question);
        return new ResponseEntity<>("Question Successfully Added!!!", HttpStatus.CREATED);
    }

    public List<Question> AllQuestions() {
        return questionRepo.findAll();
    }

    public List<Question> findByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    public void deleteById(int id) {
        questionRepo.deleteById(id);
    }

    public Question getQuestionById(int id) {
        return questionRepo.findById(id).get();
    }

    @Transactional
    public void deleteByCategory(String category) {
        questionRepo.deleteByCategory(category);
    }
}
