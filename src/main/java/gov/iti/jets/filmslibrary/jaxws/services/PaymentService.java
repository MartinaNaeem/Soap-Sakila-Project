package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.paymentDtos.PaymentGetterDto;
import gov.iti.jets.filmslibrary.dtos.paymentDtos.PaymentSetterDto;
import gov.iti.jets.filmslibrary.repository.PaymentRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class PaymentService {

    PaymentRepo paymentRepo;

    public PaymentService() {
        paymentRepo = new PaymentRepo();
    }

    public List<PaymentGetterDto> getAllPayments() {
        return paymentRepo.getAllPayments();
    }

    public Boolean addPayment(@WebParam(name = "paymentData") PaymentSetterDto paymentSetterDto) {
        paymentRepo.addPayment(paymentSetterDto);
        return true;
    }
}
