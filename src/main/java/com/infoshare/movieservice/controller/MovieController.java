package com.infoshare.movieservice.controller;

import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Movie;
import com.infoshare.movieservice.service.MovieService;
import com.infoshare.movieservice.validator.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;

    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAll(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return movieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        try {
            Movie addedMovie = movieService.addMovie(movie);
            return ResponseEntity.ok(addedMovie);
        } catch (ValidationException e) {
            LOG.warn("Movie is not created: {}", movie, e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        try {
            return movieService.updateMovie(id, movie)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (ValidationException e) {
            LOG.warn("Failed to update movie with id={} and update movie data={}", movie, e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        if (movieService.deleteMovie(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // category?category=DRAMA
    @GetMapping("/category")
    public ResponseEntity<List<Movie>> getMovieByCategory(@RequestParam Category category) {
        List<Movie> movieByCategory = movieService.findMovieByCategory(category);
        return ResponseEntity.ok(movieByCategory);
    }
}