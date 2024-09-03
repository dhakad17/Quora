package com.Quora.Quora.Services;

import com.Quora.Quora.Models.Topic;
import com.Quora.Quora.Repositories.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    public TopicService (TopicRepository topicRepository)
    {
        this.topicRepository=topicRepository;
    }

    public Topic createTopic(Topic topic)
    {
        return this.topicRepository.save(topic);
    }
}
