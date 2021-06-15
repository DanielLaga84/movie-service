package com.infoshare.movieservice.controller.dto;

import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Director;

import javax.validation.constraints.*;
import java.time.Duration;
import java.util.Objects;

public class MovieRequest {

    @Size(min = 5, max = 35)
    private String title;
    @NotNull
    private Director director;
    @Min(1)
    @Max(10)
    private Double rating;
    private Category category;
    @Min(1900)
    @Max(2021)
    private Integer year;
    @NotNull
    private Duration lengthInMinutes;

    public MovieRequest(String title, Director director, Double rating, Category category, Integer year, Duration lengthInMinutes) {
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.category = category;
        this.year = year;
        this.lengthInMinutes = lengthInMinutes;
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
        MovieRequest that = (MovieRequest) o;
        return Objects.equals(title, that.title) && Objects.equals(director, that.director) && Objects.equals(rating, that.rating) && category == that.category && Objects.equals(year, that.year) && Objects.equals(lengthInMinutes, that.lengthInMinutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, rating, category, year, lengthInMinutes);
    }

    @Override
    public String toString() {
        return "MovieRequest{" +
                "title='" + title + '\'' +
                ", director=" + director +
                ", rating=" + rating +
                ", category=" + category +
                ", year=" + year +
                ", lengthInMinutes=" + lengthInMinutes +
                '}';
    }
}
