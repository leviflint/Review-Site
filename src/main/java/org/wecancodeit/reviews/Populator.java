package org.wecancodeit.reviews;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Comments;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.CommentRepository;
import org.wecancodeit.reviews.storage.HashTagRepository;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;
    private HashTagRepository hashtagRepo;
    private CommentRepository commentRepo;

    public Populator(CategoryStorage categoryStorage, ReviewStorage reviewStorage, HashTagRepository hashtagRepo, CommentRepository commentRepo){
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
        this.hashtagRepo = hashtagRepo;
        this.commentRepo = commentRepo;

    }


    @Override
    public void run(String...args) throws Exception{

        Category healthy = new Category("Healthy", "/images/Healthy.png");
        Category sugar = new Category("Sugar", "/images/Apple Jacks.png");

        categoryStorage.addCategory(healthy);
        categoryStorage.addCategory(sugar);


        reviewStorage.addReview(new Review(healthy, "Rice Chex", "/images/Rice Chex.png", "/images/Rice Chex-nutrition.png", "Satisfying Rice Chex Cereal was the first mainstream, ready-to-eat, gluten free cereal for breakfast and beyond. A few recipe favorites include Original Chex Mix, Honey-Sriracha Chex Mix and the ever-famous Puppy Chow.", "★★  Rice “Chex”? More like Rice CHUMPZ!!! These little squares of sadness got soggy immediately, and some of them were totally busted inside the box. WHAT THE HECK! I thought this was AMERICA!"));
        reviewStorage.addReview(new Review(healthy, "Cheerios", "/images/Cheerios.png", "/images/Cheerios-nutrition.png", "Cheerios has been a family favorite for years. Made from whole grain oats, and without artificial flavors or colors, they’re naturally low in fat and cholesterol free. These wholesome little “o’s” have only one gram of sugar!", "★★★  Cheerios are exactly fine. The definition of “okie dokie.” They’re little toasty O’s that have exactly the flavor that you’d expect. They’re good for your heart, and low in cholesterol."));
        reviewStorage.addReview(new Review(healthy, "Special K", "/images/Special K.png", "/images/special-k-nutrition.png", "Special K is a brand of breakfast cereal and meal bars manufactured by Kellogg's. The cereal was introduced to the United States in 1955. Special K used to be marketed primarily as a low-fat cereal that can be eaten to help one lose weight.", "★★★  Special” may be a bit of an overstatement. But they are “original.” They definitely go with fruit, or milk, or yogurt. They’re decently healthy and definitely flakey."));

        reviewStorage.addReview(new Review(sugar, "Apple Jacks", "/images/Apple Jacks.png", "/images/Apple Jacks-nutrition.png", "Apple Jacks is a crunchy, sweetened multi-grain cereal with apple and cinnamon. Apple Jacks is one of the top four cereal brands marketed within stores and is most heavily marketed on Kellogg's internet platform.", "★★★★  Apple Jacks make me JACKED, bro!!! Cinnamon and apple collide to make these little loops BIG on flavor!! Since there’s a fruit involved, but they’re also multi-colored so they make my milk more exciting than regular cereal would."));
        reviewStorage.addReview(new Review(sugar, "Cinnamon Toast Crunch", "/images/Cinnamon Toast Crunch.png", "/images/Cinnamon Toast Crunch-nutrition.png", "An epic combination of cinnamon and sugar blasted on every square. And don’t forget to drink the Cinnamilk, the treasured milk. It’s so delicious you’ll want to crunch and slurp around the clock.", "★★★★★  The wheats are mini but the taste is MAXIMUM! They are truly a gift from the cereal gods - perfectly wrapped packages of flavor, topped with a crispy, sweet layer of frosting like the bow on a Christmas gift."));
        Review reviewToAdd1 = new Review(sugar,"Frosted Mini Wheats", "/images/frosted-mini-wheats-box.png", "/images/Frosted Mini Wheats-nutrition.png", "Frosted Mini Wheats has been a family favorite for years. Made from whole grain oats, and without artificial flavors or colors, they’re naturally low in fat and cholesterol free. These wholesome little “o’s” have only one gram of sugar!", "★★★★★  Cinnamon Toast Crunch…*chef’s kiss*. Toasty. Crunchy. Cinnamony. Cinnamon to the cinna-MAX. Toast to the MOST. Crunch on it while you BRUNCH on it. BIG YUM.");
        reviewStorage.addReview(reviewToAdd1);

        hashtagRepo.save(new Hashtag("#Jacked", reviewToAdd1));
        hashtagRepo.save(new Hashtag("#Awesome!!!",reviewToAdd1));

        commentRepo.save(new Comments("★★", "Streisand", "Barbara", reviewToAdd1));


    }
}
