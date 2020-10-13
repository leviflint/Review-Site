package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;

import java.util.Collections;

@Controller
public class ReviewController {

    @RequestMapping({"/review/{id}"})
    public String showOneCerealPage(Model model){
        Category sampleCerealCategory = new Category("Healthy", "/images/rice-chex-box1.png", Collections.EMPTY_LIST, 1);
        Review sampleCerealPage = new Review(sampleCerealCategory, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are cool.", "#Crispy", 1 );

        model.addAttribute("cerealReview", sampleCerealPage);

        return "review-template";

    }
}
