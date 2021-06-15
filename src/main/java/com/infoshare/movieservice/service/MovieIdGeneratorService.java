package com.infoshare.movieservice.service;

import com.infoshare.movieservice.model.movie.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MovieIdGeneratorService {

    private AtomicLong currentId = new AtomicLong(2);

    public long generateNewId(List<Movie> movies) {
        return currentId.incrementAndGet();
    }
}
