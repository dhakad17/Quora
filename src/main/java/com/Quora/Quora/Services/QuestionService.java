package com.Quora.Quora.Services;

import com.Quora.Quora.Models.Question;
import com.Quora.Quora.Repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository)
    {
        this.questionRepository=questionRepository;
    }

    public Question createQuestion(Question question)
    {
        return this.questionRepository.save(question);
    }

    public List<Question> searchQuestion(String title,String topic)
    {
        return this.questionRepository.findByTopicNameAndTitle(title,topic);
    }
}
