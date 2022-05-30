package com.example.restdata;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Valid
@Table(name = "title")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id cannot be null")
    private int id;

    @NotEmpty(message = "title cannot be empty")
    private String name;

    private String date_added;

    @Range(min = 1, max = 2022, message = "release_year must be lower or equal to 2022")
    private String release_year;

    private String rating;

    private String duration;

    private String description;

    private int num_ratings;

    private float user_rating;

    @ManyToMany
    @JoinTable(name = "title_actor",
            joinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Actor> cast;

    @ManyToMany
    @JoinTable(name = "title_category",
            joinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Category> listed_in;

    @ManyToMany
    @JoinTable(name = "title_director",
            joinColumns = {
                    @JoinColumn(name = "title_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "director_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Director> directores;

    public Title() {

    }

    public Title(String name, String date_added, String release_year, String rating, String duration, String description, int num_ratings, float user_rating) {
        this.name = name;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.num_ratings = num_ratings;
        this.user_rating = user_rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNum_ratings() {
        return num_ratings;
    }

    public void setNum_ratings(int num_ratings) {
        this.num_ratings = num_ratings;
    }

    public float getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(float user_rating) {
        this.user_rating = user_rating;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public List<Category> getListed_in() {
        return listed_in;
    }

    public void setListed_in(List<Category> listed_in) {
        this.listed_in = listed_in;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_added='" + date_added + '\'' +
                ", release_year='" + release_year + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", num_ratings=" + num_ratings +
                ", user_rating=" + user_rating +
                ", cast=" + cast +
                ", listed_in=" + listed_in +
                ", directores=" + directores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return id == title.id && num_ratings == title.num_ratings && Float.compare(title.user_rating, user_rating) == 0 && Objects.equals(name, title.name) && Objects.equals(date_added, title.date_added) && Objects.equals(release_year, title.release_year) && Objects.equals(rating, title.rating) && Objects.equals(duration, title.duration) && Objects.equals(description, title.description) && Objects.equals(cast, title.cast) && Objects.equals(listed_in, title.listed_in) && Objects.equals(directores, title.directores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date_added, release_year, rating, duration, description, num_ratings, user_rating, cast, listed_in, directores);
    }

}
