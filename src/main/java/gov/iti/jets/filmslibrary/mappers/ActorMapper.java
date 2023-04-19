package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorFilmGetterDto;
import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorGetterDto;
import gov.iti.jets.filmslibrary.model.Actor;
import gov.iti.jets.filmslibrary.model.FilmActor;

import java.util.ArrayList;
import java.util.List;

public class ActorMapper {

    public ActorGetterDto toActorGetter(Actor actor){
        ActorGetterDto actorGetterDto = new ActorGetterDto();
        actorGetterDto.setActorId(actor.getActorId());
        actorGetterDto.setFirstName(actor.getFirstName());
        actorGetterDto.setLastName(actor.getLastName());
        if(actor.getFilmActorList().size()>0){
            List<ActorFilmGetterDto> actorFilmGetterDtoList = new ArrayList<>();
            for(FilmActor filmActor: actor.getFilmActorList()){
                actorFilmGetterDtoList.add(new ActorFilmGetterDto().builder()
                                            .filmId(filmActor.getFilm().getFilmId())
                                            .filmTitle(filmActor.getFilm().getTitle()).build());
            }
            actorGetterDto.setActorFilmGetterDtoList(actorFilmGetterDtoList);
        }
        return actorGetterDto;

    }
}
