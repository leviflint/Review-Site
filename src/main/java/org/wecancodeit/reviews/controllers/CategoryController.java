package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;

import java.util.*;

@Controller
public class CategoryController {

    Map<Long, Category> categoryList = new HashMap<>();

    public CategoryController() {

        Collection<Review> healthyCereals = new ArrayList<>();

        Category healthy = new Category("Healthy", "/images/rice-chex-box1.png", healthyCereals, 1);
        Category sugar = new Category("Sugar", "/images/rice-chex-box1.png", healthyCereals, 2);

        healthyCereals.add(new Review(healthy, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are cool.", "#Crispy", 1));
        healthyCereals.add(new Review(healthy, "Cheerios", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are cool.", "#Crispy", 2));

        categoryList.put(healthy.getId(), healthy);
        categoryList.put(sugar.getId(), sugar);
    }

    @RequestMapping("/categories/{id}")
    public String displaySingleCategory(Model model, @PathVariable Long id) {

        model.addAttribute("category", categoryList.get(id));
        return "category-template";
    }

////    @RequestMapping("category/{id}")
//    public String displaySingleReview(Model model, @PathVariable Long id) {
//        model.addAttribute("category", categoryList.get(id));
//        return "review-template";
//    }
}

