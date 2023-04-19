package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.rentsDtos.AllRentsDto;
import gov.iti.jets.filmslibrary.dtos.rentsDtos.RentalSetterDto;
import gov.iti.jets.filmslibrary.repository.RentingRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class RentingService {

    RentingRepo rentingRepo;

    public RentingService() {
        rentingRepo = new RentingRepo();
    }

    public List<AllRentsDto> getAllRents(){
        return rentingRepo.getAllRents();
    }

    public void  rentFilm(@WebParam(name="rentingData") RentalSetterDto rentalSetterDto){
        rentingRepo.rentFilm(rentalSetterDto);
    }
    public void returnFilm(@WebParam(name="rentalId") Integer rentalId){
        rentingRepo.returnFilm(rentalId);
    }


    }
