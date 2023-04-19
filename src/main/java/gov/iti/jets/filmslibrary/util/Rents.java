package gov.iti.jets.filmslibrary.util;

import gov.iti.jets.filmslibrary.dtos.rentsDtos.CustomerPaymentGetterDto;
import gov.iti.jets.filmslibrary.dtos.rentsDtos.CustomerRentsGetterDto;
import gov.iti.jets.filmslibrary.model.Payment;
import gov.iti.jets.filmslibrary.model.Rental;

import java.util.ArrayList;
import java.util.List;

public class Rents {

    public static CustomerRentsGetterDto getCustomerRents(Rental rental){

            CustomerRentsGetterDto customerRentsGetterDto = new CustomerRentsGetterDto().builder()
                    .rentalId(rental.getRentalId())
                    .rentalDate(rental.getRentalDate())
                    .inventoryId(rental.getInventoryId().getInventoryId())
                    .filmId(rental.getInventoryId().getFilmId().getFilmId())
                    .filmTitle(rental.getInventoryId().getFilmId().getTitle())
                    .storeId(rental.getInventoryId().getStoreId().getStoreId())
                    .build();

            if(rental.getReturnDate()!= null)
                customerRentsGetterDto.setReturnDate(rental.getReturnDate());
            if(rental.getPaymentList().size()!=0){
                List<CustomerPaymentGetterDto> customerPaymentGetterDtoList = new ArrayList<>();
                for(Payment payment:rental.getPaymentList()){
                    customerPaymentGetterDtoList.add(new CustomerPaymentGetterDto().builder()
                            .paymentId(payment.getPaymentId())
                            .paymentDate(payment.getPaymentDate())
                            .amount(payment.getAmount()).build());
                }
                customerRentsGetterDto.setCustomerPaymentGetterDtoList(customerPaymentGetterDtoList);
            }


        return customerRentsGetterDto;
    }
}
