package com.Quora.Quora.Dto;

import lombok.*;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDto {
    private UUID quesId;
    private Date createdAt;
    private Date updatedAt;
    protected String question;
    protected Long UserId;
}
