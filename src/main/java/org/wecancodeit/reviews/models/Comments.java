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
    private String author;
    @ManyToMany
    private Collection<Review> reviews;


    protected Comments() {
    }

    public Comments(String author, String comment, Review... reviews) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return id == comments.id &&
                comment.equals(comments.comment) &&
                author.equals(comments.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, author);
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}



