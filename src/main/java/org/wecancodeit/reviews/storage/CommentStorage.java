package org.wecancodeit.reviews.storage;


import org.attoparser.dom.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentStorage {

    private CommentRepository commentRepo;

    public CommentStorage (CommentRepository commentRepo){
        this.commentRepo=commentRepo;
    }

    public void addComment(Comment commentToAdd){
        commentRepo.save(commentToAdd);

    }

    public Iterable <Comment> retrieveAllComments(){
        return commentRepo.findAll();
    }



}
