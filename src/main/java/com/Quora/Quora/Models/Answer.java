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
public class Answer extends BaseModel{


    @Column(nullable = false)
    private String text;

    @ManyToOne
    private User user;

    @ManyToOne()
    private Question questions;

    @OneToMany(mappedBy = "answer")
    private List<Comment> comments;





}
