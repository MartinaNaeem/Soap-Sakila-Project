package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.rentsDtos.AllRentsDto;
import gov.iti.jets.filmslibrary.dtos.rentsDtos.RentalSetterDto;
import gov.iti.jets.filmslibrary.model.Customer;
import gov.iti.jets.filmslibrary.model.Inventory;
import gov.iti.jets.filmslibrary.model.Rental;
import gov.iti.jets.filmslibrary.model.Staff;
import gov.iti.jets.filmslibrary.util.Rents;

import java.util.Date;

public class RentingMapper {

    public AllRentsDto toAllRents(Rental rental){
        return new AllRentsDto().builder()
                .customerId(rental.getCustomerId().getCustomerId())
                .customerName(rental.getCustomerId().getFirstName()+" "
                                + rental.getCustomerId().getLastName())
                .customerRentsGetterDto(Rents.getCustomerRents(rental))
                .build();
    }


    public Rental toRental(RentalSetterDto rentalSetterDto) {
        Rental rental = new Rental();
        rental.setRentalDate(new Date());
        rental.setStaffId(new Staff(rentalSetterDto.getStaffId()));
        rental.setLastUpdate(new Date());
        rental.setCustomerId(new Customer(rentalSetterDto.getCustomerId()));
        return rental;

    }
}
