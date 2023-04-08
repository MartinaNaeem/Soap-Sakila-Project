package gov.iti.jets.filmslibrary.services;

import gov.iti.jets.filmslibrary.dtos.ActorFilmsDto;
import gov.iti.jets.filmslibrary.dtos.CustomerGetterDto;
import gov.iti.jets.filmslibrary.dtos.CustomerSetterDto;
import gov.iti.jets.filmslibrary.mappers.CustomerMapper;
import gov.iti.jets.filmslibrary.model.CustomerList;
import gov.iti.jets.filmslibrary.repository.CustomerRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService
public class CustomerService {
    CustomerRepo customerRepo;
    CustomerMapper customerMapper;

    public CustomerService() {
        customerMapper = new CustomerMapper();
        customerRepo = new CustomerRepo();
    }


    public List<CustomerGetterDto> filterCustomers(@WebParam(name = "id") Short id,
                                                   @WebParam(name = "name") String name,
                                                   @WebParam(name = "phone")String phone,
                                                   @WebParam(name = "country")String country,
                                                   @WebParam(name = "city")String city,
                                                   @WebParam(name = "email")String email) {


        List<CustomerGetterDto> customerGetterDtoList = new ArrayList<>();
        List<CustomerList> customerLists =  customerRepo.filterCustomers(id, name, phone, country, city, email);
        for (CustomerList customer: customerLists) {
            customerGetterDtoList.add(customerMapper.toCustomerGetterDto(customer));
        }
        return customerGetterDtoList;
    }


    public List<CustomerGetterDto> getAllCustomers() {
        List<CustomerGetterDto> customerGetterDtoList = new ArrayList<>();
        List<CustomerList> customerLists =  customerRepo.getAllCustomers();
        for (CustomerList customer: customerLists) {
            customerGetterDtoList.add(customerMapper.toCustomerGetterDto(customer));
        }
        return customerGetterDtoList;
    }

   public boolean addCustomer(@WebParam(name="customerData") CustomerSetterDto customerSetterDto){
       return customerRepo.addCustomer(customerSetterDto);
   }

    public boolean updateCustomer(@WebParam(name="customerData")CustomerSetterDto customerSetterDto){
        return customerRepo.updateCustomer(customerSetterDto);
    }

   public boolean removeCustomer(@WebParam(name="id")short id) {
        return customerRepo.removeCustomer(id);
   }



}
