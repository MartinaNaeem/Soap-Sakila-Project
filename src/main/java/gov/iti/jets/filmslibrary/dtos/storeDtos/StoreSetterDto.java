package gov.iti.jets.filmslibrary.dtos.storeDtos;

import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressSetterDto;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class StoreSetterDto implements Serializable {

    private Short storeId;
    private Short managerId;
    private AddressSetterDto address;

}
