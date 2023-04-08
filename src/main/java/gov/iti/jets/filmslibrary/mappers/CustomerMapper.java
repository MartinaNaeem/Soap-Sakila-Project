package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.CustomerGetterDto;
import gov.iti.jets.filmslibrary.dtos.CustomerSetterDto;
import gov.iti.jets.filmslibrary.model.*;

import java.util.ArrayList;
import java.util.Date;

public class CustomerMapper {

    public CustomerGetterDto toCustomerGetterDto(CustomerList customer) {
        CustomerGetterDto customerGetterDto = new CustomerGetterDto();
        customerGetterDto.setName(customer.getName());
        customerGetterDto.setId(customer.getId());
        customerGetterDto.setAddress(customer.getAddress());
        customerGetterDto.setCity(customer.getCity());
        customerGetterDto.setCountry(customer.getCountry());
        customerGetterDto.setNotes(customer.getNotes());
        customerGetterDto.setZipcode(customer.getZipCode());
        customerGetterDto.setPhone(customer.getPhone());
        customerGetterDto.setAddress(customer.getAddress());
        customerGetterDto.setEmail(customer.getEmail());
        return customerGetterDto;
    }

    public Customer toCustomerEntity(CustomerSetterDto customerSetterDto) {
        Customer customer = new Customer();
        customer.setActive(customerSetterDto.isActive());
        customer.setCreateDate(new Date());
        customer.setLastUpdate(new Date());
        customer.setEmail(customerSetterDto.getEmail());
        customer.setFirstName(customerSetterDto.getFirstName());
        customer.setLastName(customerSetterDto.getLastName());
        customer.setPaymentList(new ArrayList<>());
        customer.setRentalList(new ArrayList<>());
        if(customerSetterDto.getId() != 0)
            customer.setCustomerId(customerSetterDto.getId());
        return customer;
    }

    public Address createAddress(CustomerSetterDto customerSetterDto) {

        Address address = new Address();
        address.setAddress(customerSetterDto.getAddress());
        address.setAddress2(customerSetterDto.getAddress2());
        address.setPhone(customerSetterDto.getPhone());
        address.setPostalCode(customerSetterDto.getPostalCode());
        address.setDistrict(customerSetterDto.getDistrict());
        address.setPhone(customerSetterDto.getPhone());
//        if(customerSetterDto.getAddressID() !=0){
//            System.out.println("idddd: " + customerSetterDto.getAddressID());
//            address.setAddressId(customerSetterDto.getAddressID());
//        }
        address.setLastUpdate(new Date());
//        address.setLocation(entityManager.find(Address.class, 1).getLocation());
        return address;

    }


}
