package com.infoshare.movieservice.mappers;


import com.infoshare.movieservice.model.movie.Movie;
import com.infoshare.movieservice.model.movie.dto.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieToDtoMapper {

    private final ActorToDtoMapper actorToDtoMapper;
    private final DirectorToDtoMapper directorToDtoMapper;

    MovieToDtoMapper(ActorToDtoMapper actorToDtoMapper, DirectorToDtoMapper directorToDtoMapper) {
        this.actorToDtoMapper = actorToDtoMapper;
        this.directorToDtoMapper = directorToDtoMapper;
    }

    public MovieDto convert(Movie movie){
        MovieDto movieDto = new MovieDto();

        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDirector(directorToDtoMapper.convert(movie.getDirector()));
        movieDto.setActors(actorToDtoMapper.convert(movie.getActors()));
        movieDto.setOriginCountry(movie.getOriginCountry());
        movieDto.setRating(movie.getRating());
        movieDto.setCategory(movie.getCategory());
        movieDto.setYear(movie.getYear());
        movieDto.setLengthInMinutes(movie.getLengthInMinutes());

        return movieDto;
    }
}