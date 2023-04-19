package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.cityDtos.CityGetterDto;
import gov.iti.jets.filmslibrary.dtos.cityDtos.CitySetterDto;
import gov.iti.jets.filmslibrary.model.City;
import gov.iti.jets.filmslibrary.model.Country;

import java.util.Date;

public class CityMapper {
    public City toCityEntity(CitySetterDto citySetterDto){
        City city = new City();
        city.setCity(citySetterDto.getCity());
        city.setCountryId(new Country(citySetterDto.getCountryId()));
        city.setLastUpdate(new Date());
        return city;
    }

    public CityGetterDto toCityGetter(City city) {
       return new CityGetterDto().builder()
                .cityId(city.getCityId())
                .city(city.getCity())
                .countryId(city.getCountryId().getCountryId())
                .country(city.getCountryId().getCountry())
                .build();
    }

}
