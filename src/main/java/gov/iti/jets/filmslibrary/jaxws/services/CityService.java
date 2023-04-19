package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.cityDtos.CityGetterDto;
import gov.iti.jets.filmslibrary.dtos.cityDtos.CitySetterDto;
import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventoryGetterDto;
import gov.iti.jets.filmslibrary.dtos.inventoryDtos.InventorySetterDto;
import gov.iti.jets.filmslibrary.mappers.CityMapper;
import gov.iti.jets.filmslibrary.model.City;
import gov.iti.jets.filmslibrary.repository.CityRepo;
import gov.iti.jets.filmslibrary.repository.InventoryRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CityService {
    CityRepo cityRepo;
    public  CityService() {
        cityRepo = new CityRepo();
    }

    public List<CityGetterDto> getAllCities(){
        return cityRepo.getAllCities();
    }

    public City addCity(@WebParam(name = "cityData") CitySetterDto citySetterDto) {
        return cityRepo.addCity(citySetterDto);
    }

}
