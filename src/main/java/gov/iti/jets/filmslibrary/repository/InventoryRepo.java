package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventoryGetterDto;
import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventorySetterDto;
import gov.iti.jets.filmslibrary.mappers.InventoryMapper;
import gov.iti.jets.filmslibrary.model.Inventory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class InventoryRepo {

InventoryMapper inventoryMapper;
public InventoryRepo() {
    inventoryMapper = new InventoryMapper();
}

    public List<InventoryGetterDto> getAllInventories() {
        EntityManager em = EntityFactory.getEmf().createEntityManager();
        List<Inventory> inventoryList= em.createQuery("From Inventory ").getResultList();
        List<InventoryGetterDto> inventoryGetterDtoList = new ArrayList<>();
        for(Inventory inventory: inventoryList){
           inventoryGetterDtoList.add(inventoryMapper.toInventoryGetterDto(inventory));
        }
        em.close();
        return inventoryGetterDtoList;
    }


    public boolean addInventory(InventorySetterDto inventorySetterDto) {
        EntityManager em = EntityFactory.getEmf().createEntityManager();
        em.getTransaction().begin();
        em.persist(inventoryMapper.toInventory(inventorySetterDto));
        em.getTransaction().commit();
        em.close();
        return true;
    }


    public boolean updateInventory(InventorySetterDto inventorySetterDto){
        EntityManager em = EntityFactory.getEmf().createEntityManager();
        em.getTransaction().begin();
        em.merge(inventoryMapper.toInventory(inventorySetterDto));
        em.getTransaction().commit();
        em.close();
        return true;

    }

    public boolean removeInventory(Integer inventoryId) {
        EntityManager em = EntityFactory.getEmf().createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("delete from Inventory i where i.inventoryId=: id");
        q.setParameter("id", inventoryId);
        int rows = q.executeUpdate();
        em.getTransaction().commit();
        em.close();
        if(rows>0)
            return true;
        return false;
    }

}
