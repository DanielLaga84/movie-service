package com.infoshare.movieservice.controller;

import com.infoshare.movieservice.controller.dto.MovieRequest;
import com.infoshare.movieservice.model.movie.Category;
import com.infoshare.movieservice.model.movie.Movie;
import com.infoshare.movieservice.model.movie.dto.ActorDto;
import com.infoshare.movieservice.model.movie.dto.MovieDto;
import com.infoshare.movieservice.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<MovieDto> getAll() {
        return movieService.findAll();
    }


    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable Long id) {
        return movieService.findDtoById(id);
    }

    @PostMapping
    public MovieDto addMovie(@RequestBody Movie movie) {
            return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public MovieDto updateMovie(@PathVariable Long id, @RequestBody @Valid MovieRequest movie) {
            return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean deleteMovie(@PathVariable Long id) {
      return movieService.deleteMovie(id);
    }

    // category?category=DRAMA
    @GetMapping("/category")
    public List<MovieDto> getMovieByCategory(@RequestParam Category category) {
        List<MovieDto> movieByCategory = movieService.findMovieByCategory(category);
        return movieByCategory;
    }

    @GetMapping("{id}/actors")
    public ResponseEntity<List<ActorDto>> getActorsFromSelectedMovie(@PathVariable Long id){
           return ResponseEntity.ok(movieService.findActorByIds(id));
    }
}