package com.example.crud.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 테이블과 엔티티 매핑
@Getter
@Setter
public class Member {
    @Id // 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본키의 값을 생성할 전략을 지정
    @Column(name="Member_Id")
    private Long id;
    private String name;
    private String email;

    @CreationTimestamp // 현재 시간으로 타임스탬프 생성해주는 어노테이션
    private LocalDateTime registerDate;

    @OneToMany(mappedBy="member") // 일대다 관계, member에 의해 매핑
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy="member")
    private List<Comment> comments = new ArrayList<>();
}