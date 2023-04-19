package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressSetterDto;
import gov.iti.jets.filmslibrary.dtos.customerDtos.CustomerGetterDto;
import gov.iti.jets.filmslibrary.dtos.rentsDtos.CustomerRentsGetterDto;
import gov.iti.jets.filmslibrary.dtos.customerDtos.CustomerSetterDto;
import gov.iti.jets.filmslibrary.model.*;
import gov.iti.jets.filmslibrary.util.Rents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerMapper {

    public CustomerGetterDto toCustomerGetterDto(Customer customer) {
        CustomerGetterDto customerGetterDto = new CustomerGetterDto()
                .builder()
                .id(customer.getCustomerId())
                .addressId(customer.getAddressId().getAddressId())
                .name(customer.getFirstName()+" "+customer.getLastName())
                .address(customer.getAddressId().getAddress())
                .city(customer.getAddressId().getCityId().getCity())
                .postalCode(customer.getAddressId().getPostalCode())
                .phone(customer.getAddressId().getPhone())
                .email(customer.getEmail())
                .createDate(customer.getCreateDate())
                .country(customer.getAddressId().getCityId().getCountryId().getCountry())
                .build();

        if(customer.getRentalList().size()!=0){
            List<CustomerRentsGetterDto> customerRentsGetterDtoList = new ArrayList<>();
            for(Rental rental: customer.getRentalList()){
                customerRentsGetterDtoList.add(Rents.getCustomerRents(rental));
            }

            customerGetterDto.setCustomerRentsGetterDtoList(customerRentsGetterDtoList);
        }
        if(customer.getAddressId().getLocation()!= null)
            customerGetterDto.setLocation(customer.getAddressId().getLocation());

        return customerGetterDto;
    }

    public Customer toCustomerEntity(CustomerSetterDto customerSetterDto) {
        Customer customer = new Customer();
        customer.setActive(customerSetterDto.getActive());
        customer.setCreateDate(new Date());
        customer.setLastUpdate(new Date());
        customer.setEmail(customerSetterDto.getEmail());
        customer.setFirstName(customerSetterDto.getFirstName());
        customer.setLastName(customerSetterDto.getLastName());
        customer.setPaymentList(new ArrayList<>());
        customer.setRentalList(new ArrayList<>());
        customer.setStoreId(new Store(customerSetterDto.getStoreId()));
        if(customerSetterDto.getId() != null)
            customer.setCustomerId(customerSetterDto.getId());
        return customer;
    }

    public AddressSetterDto toAddressSetter(CustomerSetterDto customerSetterDto) {

        AddressSetterDto address = new AddressSetterDto();
        address.setAddress(customerSetterDto.getAddress().getAddress());
        address.setAddress2(customerSetterDto.getAddress().getAddress2());
        address.setPhone(customerSetterDto.getAddress().getPhone());
        address.setPostalCode(customerSetterDto.getAddress().getPostalCode());
        address.setDistrict(customerSetterDto.getAddress().getDistrict());
        address.setPhone(customerSetterDto.getAddress().getPhone());
        address.setCountry(customerSetterDto.getAddress().getCountry());
        address.setCity(customerSetterDto.getAddress().getCity());
        if(customerSetterDto.getAddress().getAddressId()!=null){
            address.setAddressId(customerSetterDto.getAddress().getAddressId());
        }
        return address;

    }


}
