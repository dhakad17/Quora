package com.Quora.Quora.Controllers;

import com.Quora.Quora.Models.Topic;
import com.Quora.Quora.Services.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService)
    {
        this.topicService=topicService;
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic)
    {
        return ResponseEntity.ok(this.topicService.createTopic(topic));
    }

}
