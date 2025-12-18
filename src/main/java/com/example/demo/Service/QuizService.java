package com.example.demo.Service;

import com.example.demo.Model.Question;
import com.example.demo.Model.QuestionWrapper;
import com.example.demo.Model.Quiz;
import com.example.demo.Model.Response;
import com.example.demo.Repository.QuestionRepo;
import com.example.demo.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions= questionRepo.findrandomquestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        List<QuestionWrapper> questionforUser=new ArrayList<>();
        for(Question question:questions){
            QuestionWrapper questionWrapper=new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionforUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionforUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        Map<Integer, String> correctAnswers = new HashMap<>();
        for (Question q : questions) {
            correctAnswers.put(q.getId(), q.getCorrectAnswer());
        }
        int result = 0;
        for (Response response : responses) {
            String correct = correctAnswers.get(response.getId());
            if (correct != null &&
                    correct.equalsIgnoreCase(response.getResponse())) {
                result++;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    public ResponseEntity<List<Integer>> correctResponse(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        List<Integer> correctAnswers = new ArrayList<>();
        int i=0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getCorrectAnswer())){
                correctAnswers.add(response.getId());
            }
            i++;
        }
        return new ResponseEntity<>(correctAnswers, HttpStatus.OK);
    }
}
