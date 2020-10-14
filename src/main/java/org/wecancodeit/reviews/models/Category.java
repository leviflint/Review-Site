package org.wecancodeit.reviews.models;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue

    private long id;
    private String type;
    private String categoryImage;
    @OneToMany(mappedBy="category")
    private Collection<Review> cereals;


    public Category(String type, String categoryImage, Collection<Review> cereals, long id) {
        this.type = type;
        this.categoryImage = categoryImage;
        this.cereals = cereals;
        this.id = id;
    }

    protected Category() {

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
