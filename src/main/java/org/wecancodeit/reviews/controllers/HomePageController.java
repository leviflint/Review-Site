package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;

import java.util.*;

@Controller
public class HomePageController{

    @RequestMapping("")
    public String displayHomePage (Model model) {
        Category healthy = new Category("healthy", "/images/rice-chex-box1.png", Collections.emptyList(), 1);
        Category sugar = new Category("sugar", "/images/AppleJacks 3D.png", Collections.emptyList(), 2);
        Collection<Category> categories = List.of(healthy, sugar);
        model.addAttribute("categories", categories);
        return "home-template";
    }
}
