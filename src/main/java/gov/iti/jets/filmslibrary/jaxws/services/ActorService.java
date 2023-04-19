package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorGetterDto;
import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorSetterDto;
import gov.iti.jets.filmslibrary.repository.ActorRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class ActorService {

    ActorRepo actorRepo;
    public ActorService() {
        actorRepo = new ActorRepo();
    }

    public List<ActorGetterDto> getAllActors() {
        return actorRepo.getAllActors();
    }

    public boolean addActor(@WebParam(name="actorData") ActorSetterDto actorSetterDto){
        return actorRepo.addActor(actorSetterDto);
    }

    public boolean updateActor(@WebParam(name="actorData") ActorSetterDto actorSetterDto){
        return actorRepo.updateActor(actorSetterDto);
    }

    public boolean removeActor(@WebParam(name="id")Short id) {
        return actorRepo.deleteActor(id);
    }

}
