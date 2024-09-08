package com.Quora.Quora.Models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends BaseModel{


    @Column(nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    protected User answerUser;


    @ManyToOne(fetch = FetchType.LAZY)
    Question questions;


    @OneToMany(mappedBy = "commentedAnswer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    List<Comment> comments;




}
