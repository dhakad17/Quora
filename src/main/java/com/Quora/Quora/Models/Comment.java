package com.Quora.Quora.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseModel{

    @Column(nullable = false)
    private String text;

    @ManyToOne()
    private User user;

    @ManyToOne()
    private Answer answer;

    @ManyToOne()
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> comments;


}
