package com.infoshare.movieservice.fixtures;

import com.infoshare.movieservice.model.movie.Actor;
import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Director;
import com.infoshare.movieservice.model.movie.Movie;

import java.time.Duration;
import java.util.List;

public class MovieFixtures {

//    public static List<Movie> getMovies() {
//        return List.of(getFirstMovie(), getSecondMovie(),getThirdMovie(),getForthMovie());
//    }
//
//
//    private static Movie getFirstMovie() {
//        var director = new Director(1L, "Tommy", "Wiseau");
//        var actors = List.of(
//                new Actor(1L, "Tommy", "Wiseau"),
//                new Actor(2L, "Juliette", "Danielle"),
//                new Actor(3L, "Greg", "Sestero")
//        );
//        var title = "The room";
//        return new Movie(1L, title, director, actors, "USA", 3.7, Category.DRAMA, 2003, Duration.ofMinutes(99));
//    }
//
//    private static Movie getSecondMovie() {
//        var director = new Director(2L, "Tommy", "Wiseau");
//        var actors = List.of(
//                new Actor(4L, "Tommy", "Wiseau"),
//                new Actor(5L, "Juliette", "Danielle"),
//                new Actor(6L, "Greg", "Sestero")
//        );
//        var title = "The Disaster Artist";
//        return new Movie(2L, title, director, actors, "USA", 7.4, Category.BIOGRAPHY, 2017, Duration.ofMinutes(104));
//    }
//
//    private static Movie getThirdMovie() {
//        var director = new Director(3L, "Margaret", "Poplynal");
//        var actors = List.of(
//                new Actor(4L, "Agness", "Collette"),
//                new Actor(5L, "Grace", "Kamila"),
//                new Actor(6L, "Kristof", "Marciano")
//        );
//        var title = "THE SAW";
//        return new Movie(3L, title, director, actors, "POLAND", 4.5, Category.COMEDY, 2002, Duration.ofMinutes(104));
//    }
//
//    private static Movie getForthMovie() {
//        var director = new Director(4L, "GREGOR", "SCHWISSENN");
//        var actors = List.of(
//                new Actor(1L, "ARLETTE", "GENAU"),
//                new Actor(2L, "MICHAEL", "KOTANS"),
//                new Actor(3L, "GABRIEL", "TIESTO")
//        );
//        var title = "GELD";
//        return new Movie(4L, title, director, actors, "GERMAN", 7.7, Category.ADVENTURE, 1994, Duration.ofMinutes(77));
//    }

    public static List<Movie> getMovies() {
        var actorTommy = new Actor(1L, "Tommy", "Wiseau");
        var actorJuliette = new Actor(2L, "Juliette", "Danielle");
        var actorGreg = new Actor(3L, "Greg", "Sestero");

        var director1 = new Director(1L, "Tommy", "Wiseau");
        var actors1 = List.of(actorTommy, actorJuliette, actorGreg);
        var title1 = "The room";
        var movie1 = new Movie(1L, title1, director1, actors1, "USA", 3.7, Category.DRAMA, 2003, Duration.ofMinutes(99));


        var director2 = new Director(2L, "Tommy", "Wiseau");
        var actors2 = List.of(actorTommy, actorJuliette, actorGreg);
        var title2 = "The Disaster Artist";
        var movie2 = new Movie(2L, title2, director2, actors2, "USA", 7.4, Category.BIOGRAPHY, 2017, Duration.ofMinutes(104));

        var movies = List.of(movie1, movie2);

        actorTommy.setMovies(movies);
        actorJuliette.setMovies(movies);
        actorGreg.setMovies(movies);

        return movies;
    }
}