package org.wecancodeit.reviews;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.HashTagRepository;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;
    private HashTagRepository hashtagRepo;

    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage, HashTagRepository hashtagRepo){
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
        this.hashtagRepo = hashtagRepo;
    }


    @Override
    public void run(String...args) throws Exception{

        Category healthy = new Category("Healthy", "/images/Healthy.png");
        Category sugar = new Category("Sugar", "/images/Apple Jacks.png");

        categoryStorage.addCategory(healthy);
        categoryStorage.addCategory(sugar);


        reviewStorage.addReview(new Review(healthy, "Rice Chex", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Description Description", "Rice Chex are crispy AF."));
        reviewStorage.addReview(new Review(healthy, "Cheerios", "/images/Cheerios.png", "/images/Cherrios-nutrition.png", "Description Description", "Cheerios make me cheery."));
        reviewStorage.addReview(new Review(healthy, "Special K", "/images/Special K.png", "/images/special-k-nutrition.png", "Description Description", "Special K is the most special cereal EVAR"));

        reviewStorage.addReview(new Review(sugar, "Apple Jacks", "/images/Apple Jacks.png", "/images/Apple Jacks-nutrition.png", "Description Description", "Apple Jacks make me JaCkEd!"));
        reviewStorage.addReview(new Review(sugar, "Cinnamon Toast Crunch", "/images/Cinnamon Toast Crunch.png", "/images/Cinnamon Toast Crunch-nutrition.png", "Description Description", "Cinna-MON to the cinna-MAX"));
       // reviewStorage.addReview(new Review(sugar, "Frosted Mini Wheats", "/images/frosted-mini-wheats-box.png", "/images/Frosted Mini Wheats-nutrition.png", "Description Description", "Mini wheats but MEGA flavor"));

        Review reviewToAdd1 = new Review(sugar,"Frosted Mini Wheats", "/images/frosted-mini-wheats-box.png", "/images/Frosted Mini Wheats-nutrition.png", "Description Description", "Mini wheats but MEGA flavor");
        reviewStorage.addReview(reviewToAdd1);

        hashtagRepo.save(new Hashtag("#Jacked", reviewToAdd1));



    }
}
