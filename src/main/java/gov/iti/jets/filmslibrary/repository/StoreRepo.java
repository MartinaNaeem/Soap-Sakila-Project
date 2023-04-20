package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.storeDtos.StoreGetterDto;
import gov.iti.jets.filmslibrary.dtos.storeDtos.StoreSetterDto;
import gov.iti.jets.filmslibrary.mappers.AddressMapper;
import gov.iti.jets.filmslibrary.mappers.StoreMapper;
import gov.iti.jets.filmslibrary.model.Address;
import gov.iti.jets.filmslibrary.model.Store;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class StoreRepo {
    StoreMapper storeMapper;
    AddressRepo addressRepo;
    public StoreRepo(){
        storeMapper = new StoreMapper();
        addressRepo = new AddressRepo();
    }

    public List<StoreGetterDto> getAllStores(){
        EntityManager em = EntityFactory.getInstance().getEmf().createEntityManager();
        List<Store> storeList = em.createQuery("from Store").getResultList();
        List<StoreGetterDto> storeGetterDtoList = new ArrayList<>();
        for(Store store :storeList){
            storeGetterDtoList.add(storeMapper.toStoreGetter(store));
        }
        em.close();
        return  storeGetterDtoList;
    }

    public boolean addStore(StoreSetterDto storeSetterDto){
        EntityManager em = EntityFactory.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();

        Address address = addressRepo.addAddress(storeSetterDto.getAddress());

        Store store = storeMapper.toStoreEntity(storeSetterDto);
        store.setAddressId(address);

        em.persist(store);
        em.getTransaction().commit();

        em.close();
        return true;
    }


    public boolean updateStore(StoreSetterDto storeSetterDto){
        EntityManager em = EntityFactory.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();

        Address address = addressRepo.updateAddress(storeSetterDto.getAddress());

        Store store = storeMapper.toStoreEntity(storeSetterDto);
        store.setAddressId(address);
        em.merge(store);
        em.getTransaction().commit();

        em.close();
        return true;
    }


}
