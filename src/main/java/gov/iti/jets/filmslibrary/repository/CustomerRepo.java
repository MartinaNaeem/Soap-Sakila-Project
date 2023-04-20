package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.customerDtos.CustomerGetterDto;
import gov.iti.jets.filmslibrary.dtos.customerDtos.CustomerSetterDto;
import gov.iti.jets.filmslibrary.mappers.CustomerMapper;
import gov.iti.jets.filmslibrary.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepo {

    CustomerMapper customerMapper;
    AddressRepo addressRepo ;

    public CustomerRepo() {
        customerMapper = new CustomerMapper();
        addressRepo = new AddressRepo();
    }

    public List<CustomerGetterDto> filterCustomers(Short id, String name, String phone, String country,  String city, String email) {
        EntityManager em = EntityFactory.getEmf().createEntityManager();
        Query query = em.createQuery("select c from Customer c where c.customerId = coalesce(?1, c.customerId)" +
                "and lower(c.firstName+' '+ c.lastName) = coalesce(lower(?2) , lower(c.firstName+' '+ c.lastName)) " +
                "and c.addressId.phone = coalesce(?3, c.addressId.phone) " +
                "and c.addressId.cityId.countryId.country = coalesce(?4, c.addressId.cityId.countryId.country) " +
                "and c.addressId.cityId.city = coalesce(?5, c.addressId.cityId.city)" +
                "and c.email = coalesce(?6, c.email) ");
        query.setParameter(1, id);
        query.setParameter(2, name);
        query.setParameter(3,phone);
        query.setParameter(4, country);
        query.setParameter(5, city);
        query.setParameter(6, email);

        List<CustomerGetterDto> customerGetterDtoList = new ArrayList<>();
        for (Customer customer : (List<Customer>) query.getResultList()) {
            customerGetterDtoList.add(customerMapper.toCustomerGetterDto(customer));
        }
        em.close();
        return customerGetterDtoList;
    }


    public List<CustomerGetterDto> getAllCustomers() {
        EntityManager entityManager = EntityFactory.getEmf().createEntityManager();
        Query query = entityManager.createQuery("From Customer ");
        List<CustomerGetterDto> customerGetterDtoList = new ArrayList<>();
        for (Customer customer :  ( List<Customer>) query.getResultList()) {
            customerGetterDtoList.add(customerMapper.toCustomerGetterDto(customer));
        }
        entityManager.close();
        return customerGetterDtoList;

    }

    public boolean addCustomer(CustomerSetterDto customerSetterDto) {

        EntityManager entityManager = EntityFactory.getEmf().createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = customerMapper.toCustomerEntity(customerSetterDto);
        Address address = addressRepo.addAddress(customerSetterDto.getAddress());
        customer.setAddressId(address);

        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }


    public boolean updateCustomer(CustomerSetterDto customerSetterDto) {

        Address address = addressRepo.updateAddress(customerSetterDto.getAddress());

        EntityManager entityManager = EntityFactory.getEmf().createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = customerMapper.toCustomerEntity(customerSetterDto);
        customer.setAddressId(address);

        entityManager.merge(customer);
        entityManager.getTransaction().commit();
        entityManager.close();

        return true;
    }


    public boolean removeCustomer(short id) {
        EntityManager entityManager = EntityFactory.getEmf().createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, id);

        Query query = entityManager.createQuery("delete from Address a where a.id = :addressId");
        query.setParameter("addressId", customer.getAddressId().getAddressId());
        query.executeUpdate();

        query = entityManager.createQuery("delete from Customer c where c.customerId = :id");
        query.setParameter("id", customer.getCustomerId());
        query.executeUpdate();


        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }
}
