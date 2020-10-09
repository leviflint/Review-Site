package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.CerealCategory;
import org.wecancodeit.reviews.models.CerealReview;

import java.util.Collections;

@Controller
public class CerealReviewController {

    @RequestMapping("sample-cereal-page")
    public String showOneCerealPage(Model model){
        CerealCategory sampleCerealCategory = new CerealCategory("Healthy", "/images/rice-chex-box1.png", Collections.EMPTY_LIST);
        CerealReview sampleCerealPage = new CerealReview(sampleCerealCategory, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are cool.", "#Crispy", 1 );

        model.addAttribute("cerealReview", sampleCerealPage);

        return "cereal-review-template";

    }
}
