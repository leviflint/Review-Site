package org.wecancodeit.reviews.models;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", category=" + category +
                ", cerealName='" + cerealName + '\'' +
                ", boxImage='" + boxImage + '\'' +
                ", nutritionImage='" + nutritionImage + '\'' +
                ", description='" + description + '\'' +
                ", review='" + review + '\'' +
                ", hashTag='" + hashTag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return id == review1.id &&
                Objects.equals(category, review1.category) &&
                Objects.equals(cerealName, review1.cerealName) &&
                Objects.equals(boxImage, review1.boxImage) &&
                Objects.equals(nutritionImage, review1.nutritionImage) &&
                Objects.equals(description, review1.description) &&
                Objects.equals(review, review1.review) &&
                Objects.equals(hashTag, review1.hashTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, cerealName, boxImage, nutritionImage, description, review, hashTag);
    }
}



