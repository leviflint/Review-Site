package org.wecancodeit.reviews.models;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Category category;
    private String cerealName;
    private String boxImage;
    private String nutritionImage;
    private String description;
    private String review;
    private String hashTag;



    public Review(Category category, String cerealName, String boxImage, String nutritionImage, String description, String review, String hashTag) {
        this.category = category;
        this.cerealName = cerealName;
        this.boxImage = boxImage;
        this.nutritionImage = nutritionImage;
        this.description = description;
        this.review = review;
        this.hashTag = hashTag;
    }

    protected Review(){}

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getCerealName() {
        return cerealName;
    }

    public String getBoxImage() {
        return boxImage;
    }

    public String getNutritionImage() {
        return nutritionImage;
    }

    public String getDescription() {
        return description;
    }

    public String getReview() {
        return review;
    }

    public String getHashTag() {
        return hashTag;
    }



}



