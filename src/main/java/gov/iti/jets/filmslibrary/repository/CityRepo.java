package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.cityDtos.CityGetterDto;
import gov.iti.jets.filmslibrary.dtos.cityDtos.CitySetterDto;
import gov.iti.jets.filmslibrary.mappers.CityMapper;
import gov.iti.jets.filmslibrary.model.City;
import gov.iti.jets.filmslibrary.model.Country;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CityRepo {
    CityMapper cityMapper;

    public CityRepo() {
        cityMapper = new CityMapper();
    }

    public City addCity(CitySetterDto citySetterDto) {
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        City city = cityMapper.toCityEntity(citySetterDto);
        em.persist(city);
        em.getTransaction().commit();
        em.close();
        return city;

    }

    public List<CityGetterDto> getAllCities(){
        EntityManager em = EntityFactory.emf.createEntityManager();
       List<City> cities = em.createQuery("from City").getResultList();
        List<CityGetterDto> cityGetterDtoList = new ArrayList<>();
        for(City city:cities){
           cityGetterDtoList.add(cityMapper.toCityGetter(city));
       }
        em.close();
        return cityGetterDtoList;
    }
}
