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
        EntityManager em = EntityFactory.emf.createEntityManager();
        List<Store> storeList = em.createQuery("from Store").getResultList();
        List<StoreGetterDto> storeGetterDtoList = new ArrayList<>();
        for(Store store :storeList){
            storeGetterDtoList.add(storeMapper.toStoreGetter(store));
        }
        em.close();
        return  storeGetterDtoList;
    }

    public boolean addStore(StoreSetterDto storeSetterDto){
        EntityManager em = EntityFactory.emf.createEntityManager();
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
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();

        Address address = addressRepo.updateAddress(storeSetterDto.getAddress());

        System.out.println("]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
        Store store = storeMapper.toStoreEntity(storeSetterDto);
        store.setAddressId(address);
        System.out.println("66666666666666666666666666666");
        em.merge(store);
        System.out.println("7777777777777777777777777777777");
        em.getTransaction().commit();

        em.close();
        return true;
    }


}
