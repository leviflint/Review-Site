package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.CerealCategory;

import java.util.*;

@Controller
public class HomePageController{

    @RequestMapping("home")
    public String displayCerealCategoryPage (Model model) {
        CerealCategory healthy = new CerealCategory("healthy", "/images/rice-chex-box1.png", Collections.emptyList(), 1);
        CerealCategory sugar = new CerealCategory("sugar", "/images/AppleJacks 3D.png", Collections.emptyList(), 1);
        Collection<CerealCategory> categories = List.of(healthy, sugar);
        model.addAttribute("categories", categories);
        return "home-template";
    }
}
