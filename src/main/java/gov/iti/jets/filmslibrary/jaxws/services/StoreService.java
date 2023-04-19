package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventorySetterDto;
import gov.iti.jets.filmslibrary.dtos.rentsDtos.AllRentsDto;
import gov.iti.jets.filmslibrary.dtos.rentsDtos.RentalSetterDto;
import gov.iti.jets.filmslibrary.dtos.storeDtos.StoreGetterDto;
import gov.iti.jets.filmslibrary.dtos.storeDtos.StoreSetterDto;
import gov.iti.jets.filmslibrary.repository.StoreRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class StoreService {

    StoreRepo storeRepo;

    public StoreService() {
        storeRepo = new StoreRepo();
    }

    public List<StoreGetterDto> getAllStores(){
        return storeRepo.getAllStores();
    }

    public boolean addStore(@WebParam(name = "storeData") StoreSetterDto storeSetterDto) {
        return storeRepo.addStore(storeSetterDto);
    }

    public boolean updateStore(@WebParam(name = "storeData")StoreSetterDto storeSetterDto){
        return storeRepo.updateStore(storeSetterDto);
    }

}
