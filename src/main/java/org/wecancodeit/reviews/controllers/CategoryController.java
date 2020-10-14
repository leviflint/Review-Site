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
        Collection<Review> sugarCereals = new ArrayList<>();

        Category healthy = new Category("Healthy", "/images/rice-chex-box1.png", healthyCereals, 1);
        Category sugar = new Category("Sugar", "/images/AppleJacks 3D.png", sugarCereals, 2);

        healthyCereals.add(new Review(healthy, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are crispy AF.", "#Crispy", 1));
        healthyCereals.add(new Review(healthy, "Cheerios", "/images/cheerios-box.png", "/images/cherrios-nutrition.png", "Description Description", "Cheerios make me cheery.", "#Cheery", 2));
        healthyCereals.add(new Review(healthy, "Special K", "/images/special-k-box.png", "/images/special-k-nutrition.png", "Description Description", "Special K is the most special cereal EVAR", "#Special", 3));

        sugarCereals.add(new Review(sugar, "Apple Jacks", "/images/AppleJacks 3D.png", "/images/apple-jacks-nutrition.png", "Description Description", "Apple Jacks make me JaCkEd!", "#JackedBro", 4));
        sugarCereals.add(new Review(sugar, "Cinnamon Toast Crunch", "/images/cinnamon-toast-crunch-box.png", "/images/ctc-nutrition.png", "Description Description", "Cinna-MON to the cinna-MAX", "#MaximumCinnamon", 5));
        sugarCereals.add(new Review(sugar, "Frosted Mini Wheats", "/images/frosted-mini-wheats-box.png", "/images/fmw-nutrition.png", "Description Description", "Mini wheats but MEGA flavor", "#MightyWheats", 6));


        categoryList.put(healthy.getId(), healthy);
        categoryList.put(sugar.getId(), sugar);
    }

    @RequestMapping("/categories/{id}")
    public String displaySingleCategory(Model model, @PathVariable Long id) {
        model.addAttribute("categories", categoryList.get(id));
        return "category-template";
    }

////    @RequestMapping("category/{id}")
//    public String displaySingleReview(Model model, @PathVariable Long id) {
//        model.addAttribute("category", categoryList.get(id));
//        return "review-template";
//    }
}

