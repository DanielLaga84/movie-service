package com.infoshare.movieservice.model;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Movie {

    private Long id;
    private String title;
    private Director director;
    private List<Actor> actors;
    private String originCountry;
    private Double rating;
    private Category category;
    private Integer year;
    private Duration lengthInMinutes;

    public Movie(Long id, String title, Director director, List<Actor> actors, String originCountry, Double rating, Category category, Integer year, Duration lengthInMinutes) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.originCountry = originCountry;
        this.rating = rating;
        this.category = category;
        this.year = year;
        this.lengthInMinutes = lengthInMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Duration getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(Duration lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(originCountry, movie.originCountry) &&
                Objects.equals(rating, movie.rating) &&
                category == movie.category &&
                Objects.equals(year, movie.year) &&
                Objects.equals(lengthInMinutes, movie.lengthInMinutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, director, actors, originCountry, rating, category, year, lengthInMinutes);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director=" + director +
                ", actors=" + actors +
                ", originCountry='" + originCountry + '\'' +
                ", rating=" + rating +
                ", category=" + category +
                ", year=" + year +
                ", lengthInMinutes=" + lengthInMinutes +
                '}';
    }
}
