package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventoryGetterDto;
import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventorySetterDto;
import gov.iti.jets.filmslibrary.model.Film;
import gov.iti.jets.filmslibrary.model.Inventory;
import gov.iti.jets.filmslibrary.model.Store;

import java.util.Date;

public class InventoryMapper {

    public InventoryGetterDto toInventoryGetterDto(Inventory inventory){
        return new InventoryGetterDto().builder()
                .inventoryId(inventory.getInventoryId())
                .filmId(inventory.getFilmId().getFilmId())
                .filmTitle(inventory.getFilmId().getTitle())
                .storeId(inventory.getStoreId().getStoreId()).build();

    }

    public Inventory toInventory(InventorySetterDto inventorySetterDto) {
        Inventory inventory = new Inventory();
        inventory.setFilmId(new Film(inventorySetterDto.getFilmId()));
        inventory.setStoreId(new Store(inventorySetterDto.getStoreId()));
        inventory.setLastUpdate(new Date());
        if(inventorySetterDto.getInventoryId()!=null)
            inventory.setInventoryId(inventorySetterDto.getInventoryId());
        return  inventory;

    }
}
