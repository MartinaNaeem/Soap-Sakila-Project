package gov.iti.jets.filmslibrary.mappers;

import gov.iti.jets.filmslibrary.dtos.storeDtos.*;
import gov.iti.jets.filmslibrary.model.Customer;
import gov.iti.jets.filmslibrary.model.Inventory;
import gov.iti.jets.filmslibrary.model.Staff;
import gov.iti.jets.filmslibrary.model.Store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreMapper {
    public StoreGetterDto toStoreGetter(Store store) {
        StoreGetterDto storeGetterDto = new StoreGetterDto().builder()
                .managerId(store.getManagerStaffId().getStaffId())
                .managerName(store.getManagerStaffId().getFirstName() + " " + store.getManagerStaffId().getLastName())
                .storeId(store.getStoreId())
                .addressId(store.getAddressId().getAddressId())
                .address(store.getAddressId().getAddress())
                .phone(store.getAddressId().getPhone())
                .build();

        //Add Customers List Of The Store
        List<StoreCustomerGetterDto> storeCustomerGetterDtoList = new ArrayList<>();
        if (store.getCustomerList().size() > 0) {
            for (Customer customer : store.getCustomerList()) {
                storeCustomerGetterDtoList.add(new StoreCustomerGetterDto().builder()
                        .customerId(customer.getCustomerId())
                        .customerName(customer.getFirstName() + " " + customer.getLastName())
                        .build());
            }
            storeGetterDto.setCustomerList(storeCustomerGetterDtoList);
        }

        //Add Inventories List Of The Store
        List<StoreInventoryGetterDto> storeInventoryGetterDtoList = new ArrayList<>();
        if (store.getInventoryList().size() > 0) {
            for (Inventory inventory : store.getInventoryList()) {
                storeInventoryGetterDtoList.add(new StoreInventoryGetterDto().builder()
                        .inventoryId(inventory.getInventoryId())
                        .filmId(inventory.getFilmId().getFilmId())
                        .filmTitle(inventory.getFilmId().getTitle())
                        .build());
            }
            storeGetterDto.setInventoryList(storeInventoryGetterDtoList);
        }

        //Add Staff List Of The Store
        List<StoreStaffGetterDto> storeStaffGetterDtoList = new ArrayList<>();
        if (store.getStaffList().size() > 0) {
            for (Staff staff : store.getStaffList()) {
                storeStaffGetterDtoList.add(new StoreStaffGetterDto().builder()
                        .staffId(staff.getStaffId())
                        .staffName(staff.getFirstName() + " " + staff.getLastName())
                        .build());
            }
            storeGetterDto.setStaffList(storeStaffGetterDtoList);
        }


        return storeGetterDto;

    }

    public Store toStoreEntity(StoreSetterDto storeSetterDto) {
        Store store = new Store();
        store.setLastUpdate(new Date());
        store.setManagerStaffId(new Staff(storeSetterDto.getManagerId()));
        if (storeSetterDto.getStoreId() != null)
            store.setStoreId(storeSetterDto.getStoreId());

        return store;
    }
}
