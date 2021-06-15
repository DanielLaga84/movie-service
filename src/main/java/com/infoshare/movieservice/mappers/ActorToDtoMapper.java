package com.infoshare.movieservice.mappers;

import com.infoshare.movieservice.model.movie.Actor;
import com.infoshare.movieservice.model.movie.dto.ActorDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Component
public
class ActorToDtoMapper {

    ActorDto convert(Actor actor){
        ActorDto actorDto = new ActorDto();
        actorDto.setFirstName(actor.getFirstName());
        actorDto.setLastName(actor.getLastName());
        return actorDto;
    }

    public List<ActorDto> convert(List<Actor> actors) {
        return actors.stream()
                .map(this::convert)
                .collect(toUnmodifiableList());
    }
}
