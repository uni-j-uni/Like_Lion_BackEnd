package com.example.crud.Controller;

import com.example.crud.Repository.MemberRepository;
import com.example.crud.Service.CommentService;
import com.example.crud.Service.MemberService;
import com.example.crud.Service.PostService;
import com.example.crud.domain.Comment;
import com.example.crud.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final MemberService memberService;
    private final PostService postService;


    @Autowired
    public CommentController(CommentService commentService, MemberService memberService, PostService postService) {
        this.commentService = commentService;
        this.memberService = memberService;
        this.postService = postService;
    }

    // Create
    @PostMapping
    public ResponseEntity<CommentDto> registerComment(@RequestBody CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setMember(memberService.getMemberById(commentDto.getMemberId()).orElse(null));
        comment.setPost(postService.getPostById(commentDto.getPostId()).orElse(null));
        comment.setContent(commentDto.getContent());
        Comment registeredComment = commentService.registerComment(comment);
        return ResponseEntity.ok(CommentDto.from(registeredComment));
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name="id") Long id) {
        Optional<Comment> commentOptional = commentService.getCommentById(id);
        if (commentOptional.isPresent()) {
            CommentDto dto = CommentDto.from(commentOptional.get());
            return ResponseEntity.ok(dto);
        }
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(name = "id") Long id) {
        List<Comment> comments = commentService.getCommentsByPostId(id);
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDto dto = CommentDto.from(comment);
            commentDtos.add(dto);
        }
        return ResponseEntity.ok(commentDtos);
    }

    // Update
    @PatchMapping("/{id}")
    public ResponseEntity<CommentDto> UpdateCommentById(@PathVariable(name="id") Long id, @RequestBody CommentDto commentDto) {
        try {
            Comment updatedComment = commentService.updateComment(id, commentDto);
            return ResponseEntity.ok(CommentDto.from(updatedComment));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
