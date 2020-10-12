package org.wecancodeit.reviews.models;

import java.util.Collection;

public class CerealCategory {
    private String category;
    private String categoryImage;
    private Collection<CerealReview> cereals;
    private long id;

    public CerealCategory(String category, String categoryImage, Collection<CerealReview> cereals, long id) {
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

    public Collection<CerealReview> getCereals() {
        return cereals;
    }

    public long getId() {return id;}
}
