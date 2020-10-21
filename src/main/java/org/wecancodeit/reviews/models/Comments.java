package org.wecancodeit.reviews.models;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Entity
public class Comments {

    @Id
    @GeneratedValue
    private long id;
    private String comment;
    @ManyToMany
    private Collection<Review> reviews;


    protected Comments() {
    }

    public Comments(String comment, Review... reviews) {
        this.reviews = List.of(reviews);
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }


    public Collection<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return id == comments.id &&
                comment.equals(comments.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment);
    }
}



