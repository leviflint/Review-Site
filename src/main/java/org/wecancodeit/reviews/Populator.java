package org.wecancodeit.reviews;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;

    public Populator(CategoryStorage categoryStorage){

        this.categoryStorage = categoryStorage;
    }
    public Populator(ReviewStorage reviewStorage){
        this.reviewStorage = reviewStorage;
    }

    @Override
    public void run(String...args) throws Exception{

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


        categoryStorage.addCategory(healthy);
        categoryStorage.addCategory(sugar);
    }
}
