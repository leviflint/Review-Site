package org.wecancodeit.reviews.models;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
public class Comments {

    @Id
    @GeneratedValue
    private long id;
    private String author;
    private String comment;
    @ManyToMany
    private Collection<Review> reviews;


    protected Comments() {


    }

    public Comments(String author, String comment, Review...reviews) {
        this.author = author;
        this.reviews = List.of(reviews);
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}



