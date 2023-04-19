package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.paymentDtos.PaymentGetterDto;
import gov.iti.jets.filmslibrary.dtos.paymentDtos.PaymentSetterDto;
import gov.iti.jets.filmslibrary.model.Customer;
import gov.iti.jets.filmslibrary.model.Payment;
import gov.iti.jets.filmslibrary.model.Rental;
import gov.iti.jets.filmslibrary.model.Staff;

import java.util.Date;

public class PaymentMapper {

    public PaymentGetterDto toPaymentGetterDto(Payment payment) {
        PaymentGetterDto paymentGetterDto = new PaymentGetterDto().builder()
                .paymentId(payment.getPaymentId())
                .paymentDate(payment.getPaymentDate())
                .amount(payment.getAmount())
                .customerId(payment.getCustomerId().getCustomerId())
                .customerName(payment.getCustomerId().getLastName() + " " + payment.getCustomerId().getLastName())
                .build();

        if (payment.getStaffId() != null){
            paymentGetterDto.setStaffId(payment.getStaffId().getStaffId());
            paymentGetterDto.setStaffName(payment.getStaffId().getFirstName() + " " + payment.getStaffId().getLastName());

        }


        if (payment.getRentalId() != null) {
            paymentGetterDto.setInventoryId(payment.getRentalId().getInventoryId().getInventoryId());
            paymentGetterDto.setRentalDate(payment.getRentalId().getRentalDate());
            paymentGetterDto.setFilmId(payment.getRentalId().getInventoryId().getFilmId().getFilmId());
            paymentGetterDto.setFilmTitle(payment.getRentalId().getInventoryId().getFilmId().getTitle());
            paymentGetterDto.setRentalId(payment.getRentalId().getRentalId());
            if (payment.getRentalId().getReturnDate() != null)
                paymentGetterDto.setReturnDate(payment.getRentalId().getReturnDate());
        }

        return paymentGetterDto;


    }


    public Payment toPaymentEntity(PaymentSetterDto paymentSetterDto){
        Payment payment = new Payment();
        payment.setPaymentDate(new Date());
        payment.setAmount(paymentSetterDto.getAmount());
        payment.setLastUpdate(new Date());
        payment.setStaffId(new Staff(paymentSetterDto.getStaffId()));
        payment.setCustomerId(new Customer(paymentSetterDto.getCustomerId()));
        payment.setRentalId(new Rental(paymentSetterDto.getRentalId()));
        return payment;
    }
}
