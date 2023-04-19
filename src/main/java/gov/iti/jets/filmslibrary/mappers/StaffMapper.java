package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.staffDtos.StaffGetterDto;
import gov.iti.jets.filmslibrary.dtos.staffDtos.StaffSetterDto;
import gov.iti.jets.filmslibrary.model.Staff;
import gov.iti.jets.filmslibrary.model.Store;

import java.util.Date;

public class StaffMapper {
    public StaffGetterDto toStaffGetter(Staff staff) {
        return new StaffGetterDto().builder()
                .staffId(staff.getStaffId())
                .email(staff.getEmail())
                .fullName(staff.getFirstName()+" "+ staff.getLastName())
                .active(staff.getActive())
                .storeId(staff.getStoreId().getStoreId())
                .username(staff.getUsername())
                .addressId(staff.getAddressId().getAddressId())
                .address(staff.getAddressId().getAddress())
                .picture(staff.getPicture())
                .build();
    }

    public Staff toStaffEntity(StaffSetterDto staffSetterDto) {
        Staff staff = new Staff();
        staff.setActive(staffSetterDto.isActive());
        staff.setEmail(staffSetterDto.getEmail());
        staff.setLastUpdate(new Date());
        staff.setFirstName(staffSetterDto.getFirstName());
        staff.setLastName(staffSetterDto.getLastName());
//        staff.setPicture(staffSetterDto.getPicture());
        staff.setStoreId(new Store(staffSetterDto.getStoreId()));
        staff.setUsername(staffSetterDto.getUsername());
        staff.setPassword(staffSetterDto.getPassword());
        if(staffSetterDto.getStaffId() != null){
            staff.setStaffId(staffSetterDto.getStaffId());
        }
        return staff;
    }
}
