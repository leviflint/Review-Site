package org.wecancodeit.reviews.models;

import java.util.Collection;

public class Category {
    private String category;
    private String categoryImage;
    private Collection<Review> cereals;
    private long id;

    public Category(String category, String categoryImage, Collection<Review> cereals, long id) {
        this.category = category;
        this.categoryImage = categoryImage;
        this.cereals = cereals;
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public Collection<Review> getCereals() {
        return cereals;
    }

    public long getId() {return id;}
}
