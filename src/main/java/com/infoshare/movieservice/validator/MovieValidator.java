package com.infoshare.movieservice.validator;

import com.infoshare.movieservice.model.movie.Director;
import com.infoshare.movieservice.model.movie.Movie;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static com.infoshare.movieservice.validator.Validate.*;
import static org.springframework.util.Assert.isTrue;

@Component
public class MovieValidator {

    public void validateMovie(Movie movie) {
        assertAllFieldsNotNull(movie);

        validateTitle(movie.getTitle());
        validateYear(movie.getYear());
        validateDirector(movie.getDirector());
        validateRating(movie.getRating());
        validateLength(movie.getLengthInMinutes());
    }

    private void validateIsbn(String isbn) {
        notBlank(isbn);
        isFalse(isbn.length() == 13, "ISBN number must be exactly 13 characters long.");
        isTrue(isbn.contains("-"), "ISBN number must contain at least one hyphen '-'.");
    }

    private void validateTitle(String title) {
        notBlank(title);
        inclusiveBetween(5, 15, title.length());

    }

    private void validateYear(int year) {
        inclusiveBetween(1900, 2019, year);
    }

    private void validateDirector(Director director) {
        notBlank(director.getFirstName());
        notBlank(director.getLastName());
    }

    private void validateRating(Double rating) {
        inclusiveBetween(1, 10, rating);
    }

    private void validateLength(Duration lengthInMinutes) {
        if (lengthInMinutes.getSeconds() <= 0) {
            throw new ValidationException("Invalid movie duration");
        }
    }

    private void assertAllFieldsNotNull(Movie movie) {
        notNull(movie);
        notNull(movie.getId());
        notNull(movie.getTitle());
        notNull(movie.getCategory());
        notNull(movie.getDirector());
        notNull(movie.getRating());
        notNull(movie.getActors());
        notNull(movie.getOriginCountry());
        notNull(movie.getYear());
        notNull(movie.getLengthInMinutes());
    }
}
