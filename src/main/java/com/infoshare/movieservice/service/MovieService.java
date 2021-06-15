package com.infoshare.movieservice.service;

import com.infoshare.movieservice.controller.dto.MovieRequest;
import com.infoshare.movieservice.fixtures.MovieFixtures;
import com.infoshare.movieservice.mappers.ActorToDtoMapper;
import com.infoshare.movieservice.mappers.MovieToDtoMapper;
import com.infoshare.movieservice.model.movie.Actor;
import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Movie;
import com.infoshare.movieservice.model.movie.dto.ActorDto;
import com.infoshare.movieservice.model.movie.dto.MovieDto;
import com.infoshare.movieservice.validator.MovieValidator;
import com.infoshare.movieservice.validator.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class MovieService {

    private final MovieIdGeneratorService movieIdGeneratorService;
    private final MovieValidator movieValidator;
    private final MovieToDtoMapper movieToDtoMapper;
    private final ActorToDtoMapper actorToDtoMapper;


    private final List<Movie> movies = new ArrayList<>();

    public MovieService(MovieIdGeneratorService movieIdGeneratorService, MovieValidator movieValidator, MovieToDtoMapper movieToDtoMapper, ActorToDtoMapper actorToDtoMapper) {
        this.movieIdGeneratorService = movieIdGeneratorService;
        this.movieValidator = movieValidator;
        this.movieToDtoMapper = movieToDtoMapper;
        this.actorToDtoMapper = actorToDtoMapper;
        this.movies.addAll(MovieFixtures.getMovies());
    }


    public List<MovieDto> findAll() {
        return movies.stream()
                        .map(movieToDtoMapper::convert)
                        .collect(Collectors.toList());
    }

    public Movie findById(Long id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(format("Movie with id %d not found.", id)));
    }

    public MovieDto findDtoById(Long id) {
        Movie byId = findById(id);
        return movieToDtoMapper.convert(byId);
    }

    public MovieDto addMovie(Movie movie) {
        movie.setId(movieIdGeneratorService.generateNewId(movies));
//        movieValidator.validateMovie(movie);
        movies.add(movie);
        return movieToDtoMapper.convert(movie);
    }

    public MovieDto updateMovie(Long id, MovieRequest update) {
        Movie byId = findById(id);
        Movie updatedMov = updatedMovie(byId, update);
        return movieToDtoMapper.convert(updatedMov);
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

    public List<MovieDto> findMovieByCategory(Category category) {
        return movies.stream()
                .filter(n -> category.equals(n.getCategory()))
                .map(movieToDtoMapper::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<ActorDto> findActorByIds (Long id) {
        List<Actor> actors = findById(id).getActors();
        return actorToDtoMapper.convert(actors);
    }
}

