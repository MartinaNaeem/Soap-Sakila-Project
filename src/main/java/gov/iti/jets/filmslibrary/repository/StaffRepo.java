package gov.iti.jets.filmslibrary.repository;

import gov.iti.jets.filmslibrary.dtos.staffDtos.StaffGetterDto;
import gov.iti.jets.filmslibrary.dtos.staffDtos.StaffSetterDto;
import gov.iti.jets.filmslibrary.mappers.StaffMapper;
import gov.iti.jets.filmslibrary.model.Address;
import gov.iti.jets.filmslibrary.model.Staff;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class StaffRepo {
    StaffMapper staffMapper;
    AddressRepo addressRepo;
    public StaffRepo(){
        staffMapper = new StaffMapper();
        addressRepo = new AddressRepo();
    }

    public List<StaffGetterDto> getAllStaff(){
        EntityManager em = EntityFactory.emf.createEntityManager();
        List<Staff> staffList = em.createQuery("from Staff").getResultList();
        List<StaffGetterDto> staffGetterDtoList = new ArrayList<>();
        for(Staff staff: staffList){
            staffGetterDtoList.add(staffMapper.toStaffGetter(staff));
        }
        em.close();
        return staffGetterDtoList;
    }

    public boolean addStaff(StaffSetterDto staffSetterDto){
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        Staff staff = staffMapper.toStaffEntity(staffSetterDto);
        Address address = addressRepo.addAddress(staffSetterDto.getAddress());
        staff.setPicture(em.find(Staff.class, 1).getPicture());
        staff.setAddressId(address);
        em.persist(staff);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public boolean updateStaff(StaffSetterDto staffSetterDto){
        EntityManager em = EntityFactory.emf.createEntityManager();
        em.getTransaction().begin();
        Staff staff = staffMapper.toStaffEntity(staffSetterDto);
        Address address = addressRepo.updateAddress(staffSetterDto.getAddress());
        staff.setAddressId(address);
        staff.setPicture(em.find(Staff.class, 1).getPicture());
        em.merge(staff);
        em.getTransaction().commit();
        em.close();
        return true;
    }


}
