package gov.iti.jets.filmslibrary.jaxws.services;

import gov.iti.jets.filmslibrary.dtos.staffDtos.StaffGetterDto;
import gov.iti.jets.filmslibrary.dtos.staffDtos.StaffSetterDto;
import gov.iti.jets.filmslibrary.dtos.storeDtos.StoreGetterDto;
import gov.iti.jets.filmslibrary.dtos.storeDtos.StoreSetterDto;
import gov.iti.jets.filmslibrary.repository.StaffRepo;
import gov.iti.jets.filmslibrary.repository.StoreRepo;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class StaffService {

    StaffRepo staffRepo;

    public StaffService() {
        staffRepo = new StaffRepo();
    }

    public List<StaffGetterDto> getAllStaff(){
        return staffRepo.getAllStaff();
    }

    public boolean addStaff(@WebParam(name = "staffData") StaffSetterDto staffSetterDto) {
        return staffRepo.addStaff(staffSetterDto);
    }

    public boolean updateStaff(@WebParam(name = "staffData")StaffSetterDto staffSetterDto){
        return staffRepo.updateStaff(staffSetterDto);
    }
}
