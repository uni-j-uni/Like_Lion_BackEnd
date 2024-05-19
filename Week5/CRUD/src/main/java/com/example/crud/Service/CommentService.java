package com.example.crud.Service;

import com.example.crud.Repository.CommentRepository;
import com.example.crud.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    @Transactional
    public Comment registerComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

}