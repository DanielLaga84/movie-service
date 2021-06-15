package com.infoshare.movieservice.controller;

import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Movie;
import com.infoshare.movieservice.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public List<Movie> getAll(@RequestBody Movie movie) {
        return movieService.findAll();
    }


    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.findById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
            return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
            return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMovie(@PathVariable Long id) {
      return movieService.deleteMovie(id);
    }

    // category?category=DRAMA
    @GetMapping("/category")
    public List<Movie> getMovieByCategory(@RequestParam Category category) {
        List<Movie> movieByCategory = movieService.findMovieByCategory(category);
        return movieByCategory;
    }
}