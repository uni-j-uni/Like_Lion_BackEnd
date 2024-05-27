package com.example.crud.dto;

import com.example.crud.domain.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentDto {
    private String content;
    private Long memberId;
    private Long postId;

    public static CommentDto from(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setPostId(comment.getPost().getId());
        commentDto.setContent(comment.getContent());
        commentDto.setMemberId(comment.getMember().getId());
        return commentDto;
    }
}