package com.example.crud.dto;

import com.example.crud.domain.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long id;
    private MemberDto member;
    private String title;
    private String content;
    private LocalDateTime postDate;

    public static PostDto from(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setPostDate(post.getPostDate());
        if (post.getMember() != null) postDto.setMember(MemberDto.from(post.getMember()));
        return postDto;
    }
}