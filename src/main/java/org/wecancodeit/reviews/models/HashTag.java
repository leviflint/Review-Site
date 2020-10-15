package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@Entity
public class HashTag {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private Collection<Review> reviews;

    protected HashTag() {
    }

    public HashTag(String name, Review...reviews) {
        this.name = name;
        this.reviews= List.of(reviews);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "HashTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTag hashTag = (HashTag) o;
        return id == hashTag.id &&
                Objects.equals(name, hashTag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
