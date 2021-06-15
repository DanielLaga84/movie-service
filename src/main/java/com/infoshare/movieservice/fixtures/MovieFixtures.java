package com.infoshare.movieservice.fixtures;

import com.infoshare.movieservice.model.movie.Actor;
import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Director;
import com.infoshare.movieservice.model.movie.Movie;

import java.time.Duration;
import java.util.List;

public class MovieFixtures {

    public static List<Movie> getMovies() {
        return List.of(getFirstMovie(), getSecondMovie());
    }

    private static Movie getFirstMovie() {
        var director = new Director(1L, "Tommy", "Wiseau");
        var actors = List.of(
                new Actor(1L, "Tommy", "Wiseau"),
                new Actor(2L, "Juliette", "Danielle"),
                new Actor(3L, "Greg", "Sestero")
        );
        var title = "The room";
        return new Movie(1L, title, director, actors, "USA", 3.7, Category.DRAMA, 2003, Duration.ofMinutes(99));
    }

    private static Movie getSecondMovie() {
        var director = new Director(2L, "Tommy", "Wiseau");
        var actors = List.of(
                new Actor(4L, "Tommy", "Wiseau"),
                new Actor(5L, "Juliette", "Danielle"),
                new Actor(6L, "Greg", "Sestero")
        );
        var title = "The Disaster Artist";
        return new Movie(2L, title, director, actors, "USA", 7.4, Category.BIOGRAPHY, 2017, Duration.ofMinutes(104));
    }

}