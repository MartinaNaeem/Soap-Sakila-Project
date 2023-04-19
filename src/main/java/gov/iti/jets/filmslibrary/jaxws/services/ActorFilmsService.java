package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorFilmsDto;
import gov.iti.jets.filmslibrary.mappers.ActorFilmsMapper;
import gov.iti.jets.filmslibrary.repository.ActorFilmsRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class ActorFilmsService {

    ActorFilmsMapper actorFilmsMapper;
    ActorFilmsRepo actorFilmsRepo;

    public ActorFilmsService() {
        actorFilmsMapper = new ActorFilmsMapper();
        actorFilmsRepo = new ActorFilmsRepo();
    }

    public ActorFilmsDto getFilmsOfAnActor(@WebParam(name = "actorId") short id) {
        return actorFilmsMapper.toDto(actorFilmsRepo.getFilmsOFAnActor(id));
    }


    public List<ActorFilmsDto> getFilmsOfAllActors() {
        return actorFilmsRepo.getFilmsOfAllActors();
    }

    public ActorFilmsDto addExistingFilmToAnExistingActor(@WebParam(name = "filmId") short filmId, @WebParam(name = "actorId") short actorId) {
        if (actorFilmsRepo.addExistingFilmToAnExistingActor(filmId, actorId)) {
            return getFilmsOfAnActor(actorId);
        }
        return null;
    }

    public ActorFilmsDto removeFilmOfAnActor(@WebParam(name = "filmId") short filmId, @WebParam(name = "actorId") short actorId) {
       int effectedRows = actorFilmsRepo.removeFilmOfAnActor(filmId, actorId);
        if (effectedRows>0) {
            return getFilmsOfAnActor(actorId);
        }
        return null;

    }


    public boolean removeAllFilmsActors() {
       return actorFilmsRepo.removeAllFilmsActors();
    }




}
