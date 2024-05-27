package com.example.crud.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Comment_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="Post_Id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="Member_Id")
    private Member member;

    @CreationTimestamp
    private LocalDate commentDate;
    private String content;
}