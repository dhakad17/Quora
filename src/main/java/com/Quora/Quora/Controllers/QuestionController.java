package com.Quora.Quora.Controllers;

import com.Quora.Quora.Models.Question;
import com.Quora.Quora.Models.User;
import com.Quora.Quora.Services.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService)
    {
        this.questionService=questionService;
    }
    @PostMapping()
    public ResponseEntity<Question> createQuestion(@RequestBody Question question)
    {
        System.out.println(question.getQuestionUser());
        Question ques= this.questionService.createQuestion(question);

        return ResponseEntity.ok(ques);
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<Question>> searchQuestion(@RequestParam (required = false) String title,
//                                                         @RequestParam(required = false) String topic)
//    {
//        List<Question> questions=this.questionService.searchQuestion(title, topic);
//
//        return ResponseEntity.ok(questions);
//    }
}
