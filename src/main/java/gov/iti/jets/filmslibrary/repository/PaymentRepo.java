package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.paymentDtos.PaymentGetterDto;
import gov.iti.jets.filmslibrary.dtos.paymentDtos.PaymentSetterDto;
import gov.iti.jets.filmslibrary.mappers.PaymentMapper;
import gov.iti.jets.filmslibrary.model.Customer;
import gov.iti.jets.filmslibrary.model.Payment;
import gov.iti.jets.filmslibrary.model.Rental;
import gov.iti.jets.filmslibrary.model.Staff;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentRepo {

    PaymentMapper paymentMapper;
    public PaymentRepo(){
        paymentMapper = new PaymentMapper();
    }
    public List<PaymentGetterDto> getAllPayments(){
        EntityManager em = EntityFactory.emf.createEntityManager();
        List<Payment> paymentList = em.createQuery("From Payment ").getResultList();
        List<PaymentGetterDto> paymentGetterDtoList = new ArrayList<>();
        for(Payment payment: paymentList) {
            paymentGetterDtoList.add(paymentMapper.toPaymentGetterDto(payment));
        }
        em.close();
        return  paymentGetterDtoList;
    }

    public void addPayment(PaymentSetterDto paymentSetterDto) {
        EntityManager em= EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(paymentMapper.toPaymentEntity(paymentSetterDto));
        em.getTransaction().commit();
        em.close();
    }
}
