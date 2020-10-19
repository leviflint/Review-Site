package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Controller
public class ReviewController {
    private ReviewStorage reviewStorage;
    private HashtagStorage hashtagStorage;

    public ReviewController(ReviewStorage reviewStorage, HashtagStorage hashtagStorage) {
        this.reviewStorage = reviewStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @GetMapping({"/review/{id}"})
    public String showOneCerealPage(Model model, @PathVariable long id) {

        System.out.println(id);
        model.addAttribute("reviews", reviewStorage.retrieveReviewById(id));

        return "review-template";
    }
    @PostMapping({"/review/{id}"})
    public String addHashtagToReview(@RequestParam String hashtagName, @PathVariable long id) {
        Hashtag hashtagToAdd = hashtagStorage.retrieveHashtagByName(hashtagName);
        if(hashtagToAdd == null){
            hashtagToAdd = new Hashtag(hashtagName, reviewStorage.retrieveReviewById(id));
        } else {
            hashtagToAdd.addReview(reviewStorage.retrieveReviewById(id));
        }
        hashtagStorage.addHashtag(hashtagToAdd);
        System.out.println("Hey, Made it!");
        return "redirect:/review/{id}";
    }
}
//move method to hashtag storage or review storage