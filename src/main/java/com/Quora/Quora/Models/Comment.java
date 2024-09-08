package com.Quora.Quora.Models;

import jakarta.persistence.*;
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
    protected Answer commentedAnswer;

    @ManyToOne()
    protected User commentUser;

    @ManyToOne(cascade = CascadeType.ALL)
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> comments;


}
