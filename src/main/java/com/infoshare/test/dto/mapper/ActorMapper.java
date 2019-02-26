package com.infoshare.test.dto.mapper;

import com.infoshare.test.dto.ActorDto;
import com.infoshare.test.model.Actor;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    //TODO: static czy nie static?
    public static ActorDto map(Actor actor){
        ActorDto actorDto = new ActorDto();
        actorDto.setFirstName(actor.getFirstName());
        actorDto.setLastName(actor.getLastName());
        actorDto.setId(actor.getId());
        return actorDto;
    }
}
