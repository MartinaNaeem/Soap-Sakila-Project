package gov.iti.jets.filmslibrary.dtos.storeDtos;

import gov.iti.jets.filmslibrary.model.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class StoreGetterDto implements Serializable {

    private Short storeId;
    private List<StoreStaffGetterDto> staffList;
    private Short addressId;
    private String address;
    private String phone;
    private String managerName;
    private Short managerId;
    private List<StoreInventoryGetterDto> inventoryList;
    private List<StoreCustomerGetterDto> customerList;
}
