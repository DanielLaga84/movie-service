package com.infoshare.movieservice.service;

import com.infoshare.movieservice.controller.dto.MovieRequest;
import com.infoshare.movieservice.fixtures.MovieFixtures;
import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Movie;
import com.infoshare.movieservice.validator.MovieValidator;
import com.infoshare.movieservice.validator.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

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

    public Movie findById(Long id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(format("Movie with id %d not found.", id)));
    }

    public Movie addMovie(Movie movie) {
        movie.setId(movieIdGeneratorService.generateNewId(movies));
        movieValidator.validateMovie(movie);
        movies.add(movie);
        return movie;
    }

    public Movie updateMovie(Long id, MovieRequest update) {
        Movie byId = findById(id);
        return updatedMovie(byId,update);
    }
    private Movie updatedMovie(Movie movieToUpdate, MovieRequest updatedMovie) {
        movieToUpdate.setTitle(updatedMovie.getTitle());
        movieToUpdate.setDirector(updatedMovie.getDirector());
        movieToUpdate.setRating(updatedMovie.getRating());
        movieToUpdate.setCategory(updatedMovie.getCategory());
        movieToUpdate.setYear(updatedMovie.getYear());
        movieToUpdate.setLengthInMinutes(updatedMovie.getLengthInMinutes());
        return movieToUpdate;
    }

    public boolean deleteMovie(Long id) {
      return movies.remove(findById(id));
    }

    public List<Movie> findMovieByCategory(Category category) {
        return movies.stream()
                .filter( n -> category.equals(n.getCategory()))
                .collect(Collectors.toList());
    }
}

