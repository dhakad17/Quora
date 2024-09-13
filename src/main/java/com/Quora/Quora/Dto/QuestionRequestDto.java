package com.Quora.Quora.Dto;

import lombok.*;

import java.util.UUID;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDto {
     private UUID id;
     private String title;
     private String body;
}
