package com.Quora.Quora.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public  abstract class BaseModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "Id", columnDefinition = "BINARY(16)")
    private UUID uuid;


    @Temporal(value = TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

}
