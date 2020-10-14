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
    public String showOneCerealPage(Model model) {
        Category sampleCerealCategory = new Category("Healthy", "/images/rice-chex-box1.png", Collections.emptyList(), 1);
        Category sampleCerealCategory2 = new Category("Sugar", "/images/AppleJacks 3D.png", Collections.emptyList(), 2);
        Review sampleCerealPage = new Review(sampleCerealCategory, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are cool.", "#Crispy", 1);
        Review sampleCerealPage2 = new Review(sampleCerealCategory, "Cheerios", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Cheerios are cool.", "#Crispy", 2);
        Review sampleCerealPage3 = new Review(sampleCerealCategory, "Special K", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Special K are cool.", "#Crispy", 3);
        Review sampleCerealPage4 = new Review(sampleCerealCategory2, "Apple Jacks", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Apple Jacks are cool.", "#Crispy", 4);
        Review sampleCerealPage5 = new Review(sampleCerealCategory2, "Cinnamon Toast Crunch", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Cinnamon Toast Crunch are cool.", "#Crispy", 5);
        Review sampleCerealPage6 = new Review(sampleCerealCategory2, "Crunchy Stuff", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Crunchy Stuff are cool.", "#Crispy", 6);

        model.addAttribute("reviews", sampleCerealPage);
        model.addAttribute("reviews", sampleCerealPage2);
        model.addAttribute("reviews", sampleCerealPage3);
        model.addAttribute("reviews", sampleCerealPage4);
        model.addAttribute("reviews", sampleCerealPage5);
        model.addAttribute("reviews", sampleCerealPage6);

        return "review-template";

    }
}
