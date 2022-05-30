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


    @NotEmpty(message = "show_id cannot be empty")
    private String show_id;

    @NotEmpty(message = "type cannot be empty")
    private String type;

    @NotEmpty(message = "title cannot be empty")
    private String title;

    private String country;

    private String date_added;

    @Range(min = 1, max = 2022, message = "release_year must be lower or equal to 2022")
    private int release_year;

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

    public Title(String show_id, String type, String title, String country, String date_added, int release_year, String rating, String duration, String description, int num_ratings, float user_rating) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.country = country;
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

    public String getShow_id() {
        return show_id;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", show_id='" + show_id + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", date_added=" + date_added +
                ", release_year=" + release_year +
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

    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return id == title1.id && release_year == title1.release_year && show_id.equals(title1.show_id) && type.equals(title1.type) && title.equals(title1.title) && Objects.equals(country, title1.country) && Objects.equals(date_added, title1.date_added) && Objects.equals(rating, title1.rating) && Objects.equals(duration, title1.duration) && Objects.equals(description, title1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, show_id, type, title, country, date_added, release_year, rating, duration, description);
    }
}
