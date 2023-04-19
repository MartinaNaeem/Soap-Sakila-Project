package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorGetterDto;
import gov.iti.jets.filmslibrary.dtos.actorDtos.ActorSetterDto;
import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressGetterDto;
import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressSetterDto;
import gov.iti.jets.filmslibrary.model.Address;
import gov.iti.jets.filmslibrary.repository.ActorRepo;
import gov.iti.jets.filmslibrary.repository.AddressRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class AddressService {

    AddressRepo addressRepo;
    public AddressService() {
        addressRepo = new AddressRepo();
    }

    public List<AddressGetterDto> getAllAddresses() {
        return addressRepo.getAllAddresses();
    }

    public Address addAddress(@WebParam(name="addressData") AddressSetterDto addressSetterDto){
        return addressRepo.addAddress(addressSetterDto);
    }

    public Address updateAddress(@WebParam(name="addressData") AddressSetterDto addressSetterDto){
        return addressRepo.updateAddress(addressSetterDto);
    }

}
