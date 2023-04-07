package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.ActorFilmsDto;
import gov.iti.jets.filmslibrary.model.ActorInfo;

import java.util.Arrays;

public class ActorFilmsMapper {

    public ActorFilmsDto toDto(ActorInfo actor) {
        ActorFilmsDto actorFilmsDto = new ActorFilmsDto();
        actorFilmsDto.setActorName(actor.getFirstName()+" "+actor.getLastName());
        String films = actor.getFilmInfo().replaceAll("; ([A-Za-z])\\w+:", ",");
        films = films.replaceAll("([A-Za-z])\\w+:", "");
        actorFilmsDto.setFilms(Arrays.stream(films.split(",")).toList());
        return actorFilmsDto;
    }
}
