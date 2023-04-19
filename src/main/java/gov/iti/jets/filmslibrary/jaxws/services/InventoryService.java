package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventoryGetterDto;
import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventorySetterDto;
import gov.iti.jets.filmslibrary.repository.InventoryRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class InventoryService {

    InventoryRepo inventoryRepo;
    public  InventoryService() {
        inventoryRepo = new InventoryRepo();
    }

    public List<InventoryGetterDto> getAllInventories(){
        return inventoryRepo.getAllInventories();
    }

    public boolean addInventory(@WebParam(name = "inventoryData")InventorySetterDto inventorySetterDto) {return inventoryRepo.addInventory(inventorySetterDto);}

    public boolean updateInventory(@WebParam(name = "inventoryData")InventorySetterDto inventorySetterDto){return inventoryRepo.updateInventory(inventorySetterDto);}


    public boolean removeInventory(@WebParam(name = "inventoryId") Integer inventoryId){
        return inventoryRepo.removeInventory(inventoryId);
    }
}
