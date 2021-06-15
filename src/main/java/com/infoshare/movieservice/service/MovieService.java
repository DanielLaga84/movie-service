package com.infoshare.movieservice.service;

import com.infoshare.movieservice.fixtures.MovieFixtures;
import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Movie;
import com.infoshare.movieservice.validator.MovieValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieIdGeneratorService movieIdGeneratorService;
    private final MovieValidator movieValidator;

    private final List<Movie> movies = new ArrayList<>();

    public MovieService(MovieIdGeneratorService movieIdGeneratorService, MovieValidator movieValidator) {
        this.movieIdGeneratorService = movieIdGeneratorService;
        this.movieValidator = movieValidator;
        this.movies.addAll(MovieFixtures.getMovies());
    }


    public List<Movie> findAll() {
        return movies;
    }

    public Optional<Movie> findById(Long id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }

    public Movie addMovie(Movie movie) {
        movie.setId(movieIdGeneratorService.generateNewId(movies));
        movieValidator.validateMovie(movie);
        movies.add(movie);
        return movie;
    }

    public Optional<Movie> updateMovie(Long id, Movie update) {
        return this.findById(id)
                .map( movie -> updatedMovie(movie,update));
    }
    private Movie updatedMovie(Movie movieToUpdate, Movie updatedMovie) {
        movieToUpdate.setTitle(updatedMovie.getTitle());
        movieToUpdate.setDirector(updatedMovie.getDirector());
        movieToUpdate.setActors(updatedMovie.getActors());
        movieToUpdate.setOriginCountry(updatedMovie.getOriginCountry());
        movieToUpdate.setRating(updatedMovie.getRating());
        movieToUpdate.setCategory(updatedMovie.getCategory());
        movieToUpdate.setYear(updatedMovie.getYear());
        movieToUpdate.setLengthInMinutes(updatedMovie.getLengthInMinutes());
        return movieToUpdate;
    }

    public boolean deleteMovie(Long id) {
       this.findById(id).map(movies::remove);
        return false;
    }

    public List<Movie> findMovieByCategory(Category category) {
        return movies.stream()
                .filter( n -> category.equals(n.getCategory()))
                .collect(Collectors.toList());
    }
}

