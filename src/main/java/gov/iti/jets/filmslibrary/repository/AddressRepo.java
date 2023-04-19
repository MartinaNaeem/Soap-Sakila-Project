package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressGetterDto;
import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressSetterDto;
import gov.iti.jets.filmslibrary.dtos.cityDtos.CitySetterDto;
import gov.iti.jets.filmslibrary.mappers.AddressMapper;
import gov.iti.jets.filmslibrary.model.Address;
import gov.iti.jets.filmslibrary.model.City;
import gov.iti.jets.filmslibrary.model.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressRepo {
    AddressMapper addressMapper;
    CityRepo cityRepo;
    public AddressRepo(){
        addressMapper = new AddressMapper();
        cityRepo = new CityRepo();
    }

    public Address addAddress(AddressSetterDto addressSetterDto){
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        Address address = getAddressWithCity(addressSetterDto);
        em.persist(address);
        em.getTransaction().commit();
        em.close();
        return address;
    }

    public Address updateAddress(AddressSetterDto addressSetterDto){
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        Address address = getAddressWithCity(addressSetterDto);
        em.merge(address);
        em.getTransaction().commit();
        em.close();
        return address;
    }

    public List<AddressGetterDto> getAllAddresses(){
        EntityManager em = EntityFactory.emf.createEntityManager();
        List<Address> addressList = em.createQuery("from Address").getResultList();
        List<AddressGetterDto> addressGetterDtoList = new ArrayList<>();
        for(Address address:addressList){
            addressGetterDtoList.add(addressMapper.toAddressGetter(address));
        }
        em.close();
        return addressGetterDtoList;
    }


    private Address getAddressWithCity(AddressSetterDto addressSetterDto){
        Address address = addressMapper.toAddressEntity(addressSetterDto);
        EntityManager em = EntityFactory.emf.createEntityManager();
        address.setLocation(em.find(Address.class, 1).getLocation());

        Query q = em.createQuery("From City c where lower(c.city) = :city");
        q.setParameter("city", addressSetterDto.getCity().toLowerCase());

        City city = null;
        try {
            city = (City) q.getSingleResult();
            if (city != null) {
                city.setLastUpdate(new Date());
                city.setCountryId(new Country(addressSetterDto.getCountry()));
                em.merge(city);
            }
        } catch (NoResultException e) {
           city = cityRepo.addCity(new CitySetterDto().builder().city(addressSetterDto.getCity())
                    .countryId(addressSetterDto.getCountry()).build());
        }
        address.setCityId(city);
        em.close();
        return address;
    }


}
