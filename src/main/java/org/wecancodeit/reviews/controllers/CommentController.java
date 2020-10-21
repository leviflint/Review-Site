package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.models.Comments;
import org.wecancodeit.reviews.storage.CommentStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;


@Controller
public class CommentController {

    private ReviewStorage reviewStorage;
    private CommentStorage commentStorage;


    public CommentController(ReviewStorage reviewStorage, CommentStorage commentStorage) {
        this.reviewStorage = reviewStorage;
        this.commentStorage = commentStorage;
    }

    @RequestMapping(method = RequestMethod.POST, value= {"/review/{id}"}, params = {"commentText"} )
    public String addCommentToReview(@RequestParam String commentText, @PathVariable long id) {
        Comments commentToAdd = new Comments("Barbara", commentText , reviewStorage.retrieveReviewById(id)) ;
        commentStorage.addComment(commentToAdd);
        return "redirect:/review/{id}";
    }
}
