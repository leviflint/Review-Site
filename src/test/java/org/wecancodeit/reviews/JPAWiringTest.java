package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.HashTag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryRepository;
import org.wecancodeit.reviews.storage.HashTagRepository;
import org.wecancodeit.reviews.storage.ReviewRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

public class JPAWiringTest {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private HashTagRepository hashTagRepo;

    @Test
    public void categoryHasManyReviewsAndReviewsHaveOneCategory () {
        Category testCategory = new Category("healthy", "/images/pic.jpg");
        categoryRepo.save(testCategory);
        Review testReview1 = new Review(testCategory, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are crispy AF.", "#Crispy");
        Review testReview2 = new Review(testCategory, "Raisin Bran", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Raisin Bran is okay I guess.", "#Meh");
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        testEntityManager.flush();
        testEntityManager.clear();
        Category retrievedCategory = categoryRepo.findById(testCategory.getId()).get();
        assertThat(retrievedCategory.getCereals()).contains(testReview1, testReview2);
        assertThat(retrievedCategory).isEqualTo(testCategory);
    }

    @Test
    public void reviewHasManyHashTagsAndHashTagsHaveManyReviews(){
        Category testCategory = new Category("healthy", "/images.png");
        categoryRepo.save(testCategory);
        Review testReview1 = new Review(testCategory, "Rice Chex", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Rice Chex are crispy AF.", "#Crispy");
        Review testReview2 = new Review(testCategory, "Raisin Bran", "/images/rice-chex-box.png", "/images/rice-chex-nutrition.png", "Description Description", "Raisin Bran is okay I guess.", "#Meh");
        reviewRepo.save(testReview1);
        reviewRepo.save(testReview2);
        HashTag testHashTag1 = new HashTag("#Crispy", testReview1, testReview2);
        HashTag testHashTag2 = new HashTag("#BurgerWanted", testReview1);
        HashTag testHashTag3 = new HashTag("#Unnecessary", testReview1, testReview2);
        hashTagRepo.save(testHashTag1);
        hashTagRepo.save(testHashTag2);
        hashTagRepo.save(testHashTag3);
        testEntityManager.flush();
        testEntityManager.clear();


    }
}
