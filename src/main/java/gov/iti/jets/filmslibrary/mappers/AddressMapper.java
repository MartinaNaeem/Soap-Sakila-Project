package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressGetterDto;
import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressSetterDto;
import gov.iti.jets.filmslibrary.dtos.addressDtos.CustomerAddressGetterDto;
import gov.iti.jets.filmslibrary.dtos.addressDtos.StaffAddressGetterDto;
import gov.iti.jets.filmslibrary.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressMapper {
    public Address toAddressEntity(AddressSetterDto addressSetterDto) {
        Address address = new Address();
        address.setAddress(addressSetterDto.getAddress());
        address.setAddress2(addressSetterDto.getAddress2());
        address.setPhone(addressSetterDto.getPhone());
        address.setPostalCode(addressSetterDto.getPostalCode());
        address.setDistrict(addressSetterDto.getDistrict());
        address.setPhone(addressSetterDto.getPhone());
        address.setLastUpdate(new Date());
        if(addressSetterDto.getAddressId() != null){
            address.setAddressId(addressSetterDto.getAddressId());
        }
        return address;
    }

    public AddressGetterDto toAddressGetter(Address address) {
        AddressGetterDto addressGetterDto = new AddressGetterDto().builder()
                .address(address.getAddress())
                .addressId(address.getAddressId())
                .address2(address.getAddress2())
                .country(address.getCityId().getCountryId().getCountry())
                .countryId(address.getCityId().getCountryId().getCountryId())
                .city(address.getCityId().getCity())
                .cityId(address.getCityId().getCityId())
                .phone(address.getPhone())
                .district(address.getDistrict())
                .location(address.getLocation())
                .postalCode(address.getPostalCode())
                .build();


        //ADD STORES' IDs TO THE ADDRESS
        if(address.getStoreList().size()!=0){
            List<Short> stores = new ArrayList<>();
            for(Store store: address.getStoreList()){
                stores.add(store.getStoreId());
            }
            addressGetterDto.setStores(stores);
        }

        //ADD STAFF OF THE ADDRESS
        if(address.getStaffList().size()!=0){
            List<StaffAddressGetterDto> staffAddressGetterDtoList = new ArrayList<>();
            for(Staff staff: address.getStaffList()){
                staffAddressGetterDtoList.add(new StaffAddressGetterDto().builder()
                        .staffId(staff.getStaffId())
                        .staffName(staff.getFirstName()+" "+ staff.getLastName()).build());
            }
            addressGetterDto.setStaff(staffAddressGetterDtoList);
        }

        //ADD CUSTOMERS OF THE ADDRESS
        if(address.getCustomerList().size()!=0){
            List<CustomerAddressGetterDto> customerAddressGetterDtoList = new ArrayList<>();
            for(Customer customer: address.getCustomerList()){
                customerAddressGetterDtoList.add(new CustomerAddressGetterDto().builder()
                        .customerId(customer.getCustomerId())
                        .customerName(customer.getFirstName()+" "+ customer.getLastName()).build());
            }
            addressGetterDto.setCustomers(customerAddressGetterDtoList);
        }

        return addressGetterDto;
    }
}
