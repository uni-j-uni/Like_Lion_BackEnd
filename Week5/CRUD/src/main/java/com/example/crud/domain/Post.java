package com.example.crud.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {
    @Id // 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본키의 값을 생성할 전략을 지정
    @Column(name="Post_Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="Member_Id")
    private Member member;
    private String title;
    private String content;

    @CreationTimestamp // 현재 시간으로 타임스탬프 생성해주는 어노테이션
    private LocalDateTime postDate;

    @OneToMany(mappedBy="post")
    private List<Comment> comments = new ArrayList<>();
}
