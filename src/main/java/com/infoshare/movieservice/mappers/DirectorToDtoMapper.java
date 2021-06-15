package com.infoshare.movieservice.mappers;

import com.infoshare.movieservice.model.movie.Director;
import com.infoshare.movieservice.model.movie.dto.DirectorDto;
import org.springframework.stereotype.Component;

@Component
class DirectorToDtoMapper {

    DirectorDto convert(Director director){
        DirectorDto directorDto = new DirectorDto();
        directorDto.setFirstName(director.getFirstName());
        directorDto.setLastName(director.getLastName());
        return directorDto;
    }
}
