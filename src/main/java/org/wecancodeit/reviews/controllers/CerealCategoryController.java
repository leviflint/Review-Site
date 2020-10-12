package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.CerealCategory;
import org.wecancodeit.reviews.models.CerealReview;

import java.util.*;

@Controller
public class CerealCategoryController {

    Map<Long, CerealCategory> categoryList = new HashMap<>();

    public CerealCategoryController() {

        Collection<CerealReview> healthyCereals = new ArrayList<>();

        CerealCategory healthy = new CerealCategory("Healthy", "/images/rice-chex-box1.png", Collections.EMPTY_LIST, 1);
        CerealCategory sugar = new CerealCategory("Sugar", "/images/rice-chex-box1.png", Collections.EMPTY_LIST, 2);

        healthyCereals.add(new CerealReview(healthy, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are cool.", "#Crispy", 1));
        healthyCereals.add(new CerealReview(healthy, "Cheerios", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are cool.", "#Crispy", 2));

        categoryList.put(healthy.getId(), healthy);
        categoryList.put(sugar.getId(), sugar);
    }

    @RequestMapping({"", "/"})
    public String displayCerealCategoryPage(Model model) {
        model.addAttribute("category", categoryList.values());
        return "cereal-category-template";
    }

    @RequestMapping("category/{id}")
    public String displaySingleCereal(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryList.get(id));
        return "cereal-review-template";
    }
}

