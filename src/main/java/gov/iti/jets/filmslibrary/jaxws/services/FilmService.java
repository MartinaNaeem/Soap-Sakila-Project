package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmFilterDto;
import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmGetterDto;
import gov.iti.jets.filmslibrary.dtos.filmDtos.FilmSetterDto;
import gov.iti.jets.filmslibrary.repository.FilmRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class FilmService {

    FilmRepo filmRepo;
    public FilmService() {
        filmRepo = new FilmRepo();
    }


    public List<FilmGetterDto> filterFilms(@WebParam(name="filmData") FilmFilterDto filmFilterDto) {
        return filmRepo.filterFilms(filmFilterDto);
    }


    public List<FilmGetterDto> getAllFilms() {
        return filmRepo.getAllFilms();
    }

    public boolean addFilm(@WebParam(name="filmData") FilmSetterDto filmSetterDto){
        return filmRepo.addFilm(filmSetterDto);
    }

    public boolean updateFilm(@WebParam(name="filmData") FilmSetterDto filmSetterDto){
        return filmRepo.updateFilm(filmSetterDto);
    }

    public boolean removeFilm(@WebParam(name="id")short id) {
        return filmRepo.removeFilm(id);
    }


}
