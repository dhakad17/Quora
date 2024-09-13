package com.Quora.Quora.Controllers;

import com.Quora.Quora.Dto.QuestionRequestDto;
import com.Quora.Quora.Models.Question;
import com.Quora.Quora.Models.User;
import com.Quora.Quora.Services.QuestionService;
import com.Quora.Quora.Services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

   private QuestionService questionService;
   private UserService userService;

   public QuestionController (QuestionService questionService,UserService userService)
   {
       this.questionService=questionService;
       this.userService=userService;
   }

   @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody QuestionRequestDto ques) throws EntityNotFoundException
   {
       User u=userService.getUserByEmail("john.doe@example.com");

       System.out.println(u.getUsername()+" "+u.getUuid());
       System.out.println("---------------------------------------------+++++++>>>>>>>>>>>>");
       System.out.println(ques.getId()+" "+ques.getTitle()+" "+ques.getBody());
       UUID uuid=ques.getId();
       User user=userService.getUser(uuid);
       boolean userExist=userService.checkUser(uuid);

       if(!userExist)
       {
           throw new RuntimeException("User with ID"+uuid+" not found in DB");
       }
       Question question=Question.builder().questionUser(user).body(ques.getBody()).title(ques.getTitle()).build();

       questionService.createQuestion(question);
       return ResponseEntity.ok(question);
   }
}
