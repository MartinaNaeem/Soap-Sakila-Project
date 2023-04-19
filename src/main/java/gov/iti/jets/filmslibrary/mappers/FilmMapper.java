package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.filmDtos.EmbeddedInventoryDto;
import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmGetterDto;
import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmSetterDto;
import gov.iti.jets.filmslibrary.model.Film;
import gov.iti.jets.filmslibrary.model.FilmList;

import java.util.*;

public class FilmMapper {

   public FilmGetterDto toGetterDto(FilmList filmList) {
       FilmGetterDto filmGetterDto = new FilmGetterDto();
       filmGetterDto = filmGetterDto.builder()
               .fid(filmList.getFid())
               .category(filmList.getCategory())
               .language(filmList.getLanguage())
               .length(filmList.getLength())
               .description(filmList.getDescription())
               .rating(filmList.getRating())
               .releaseYear(filmList.getReleaseYear())
               .rentalRate(filmList.getRentalRate())
               .lastUpdate(filmList.getLastUpdate())
               .replacementCost(filmList.getReplacementCost())
               .rentalDuration(filmList.getRentalDuration())
               .title(filmList.getTitle())
               .build();
       if (filmList.getActors() != null) {
           filmGetterDto.setActors(Arrays.stream(filmList.getActors().split(",\\s")).toList());
       }
       if (filmList.getSpecialFeatures() != null) {
           filmGetterDto.setSpecialFeature(Arrays.stream(filmList.getSpecialFeatures().split(",")).toList());
       }

       if(filmList.getInventories() != null) {
           List<EmbeddedInventoryDto> inventoryList = new ArrayList<>();
           for(String part: filmList.getInventories().split(",\\s")){
               Integer inventoryId = Integer.parseInt(part.split(":")[0]);
               Short storeId = Short.parseShort(part.split(":")[1]);
               inventoryList.add(new EmbeddedInventoryDto(inventoryId, storeId));
           }
           filmGetterDto.setInventoriesList(inventoryList);
       }
       return filmGetterDto;
   }

   public Film toFilmEntity(FilmSetterDto filmSetterDto) {
       Film film = new Film();
       return film.builder()
               .description(filmSetterDto.getDescription())
               .length(filmSetterDto.getLength())
               .lastUpdate(new Date())
               .rating(filmSetterDto.getRating())
               .releaseYear(filmSetterDto.getReleaseYear())
               .title(filmSetterDto.getTitle())
               .specialFeatures(filmSetterDto.getSpecialFeatures())
               .replacementCost(filmSetterDto.getReplacementCost())
               .rentalRate(filmSetterDto.getRentalRate())
               .rentalDuration(filmSetterDto.getRentalDuration()).build();
   }


}
