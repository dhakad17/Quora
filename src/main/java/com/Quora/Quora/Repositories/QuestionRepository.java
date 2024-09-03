package com.Quora.Quora.Repositories;

import com.Quora.Quora.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {


    @Query("SELECT q FROM Question q JOIN q.topics t WHERE (:title IS NULL OR q.title LIKE %:title%) AND (:topicName IS NULL OR t.name = :topicName)")
    List<Question> findByTopicNameAndTitle(@Param("title") String title, @Param("topicName") String topicName);

}
