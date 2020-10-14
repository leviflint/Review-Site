package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.ReviewStorage;

import java.util.Collections;

@Controller
public class ReviewController {
    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage){
        this.reviewStorage = reviewStorage;
    }

    @RequestMapping({"/review/{id}"})
    public String showOneCerealPage(Model model, @PathVariable long id) {
        model.addAttribute("reviews", reviewStorage.retrieveReviewById(id));

        return "review-template";

    }
}
