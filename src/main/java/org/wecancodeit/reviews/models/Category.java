package org.wecancodeit.reviews.models;

import java.util.Collection;

public class Category {
    private String type;
    private String categoryImage;
    private Collection<Review> cereals;
    private long id;

    public Category(String type, String categoryImage, Collection<Review> cereals, long id) {
        this.type = type;
        this.categoryImage = categoryImage;
        this.cereals = cereals;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public Collection<Review> getCereals() {
        return cereals;
    }

    public long getId() {return id;}
}
