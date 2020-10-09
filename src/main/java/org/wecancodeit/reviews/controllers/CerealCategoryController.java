package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.wecancodeit.reviews.models.CerealCategory;
import org.wecancodeit.reviews.models.CerealReview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CerealCategoryController {
    Map<Long,CerealCategory> categoryList = new HashMap<>();

    public CerealCategoryController () {

        Collection<CerealReview> healthyList = new ArrayList<>();
        Collection<CerealReview> sugarList = new ArrayList<>();

        CerealCategory healthy = new CerealCategory("Healthy", "/images/rice-chex-box1.png", healthyList);
        CerealCategory sugar = new CerealCategory("Sugary", "/images/AppleJacks1.png", sugarList);

//        @RequestMapping({"", "/"})
//        public String displayHomePage(Model model) {
//            model.addAttribute("categories", categoryStorage.retrieveAllCategories());
//            return "home";
//        }

        //Model attribute to add 'categories'
    }
}
