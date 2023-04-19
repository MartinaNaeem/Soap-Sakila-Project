package gov.iti.jets.filmslibrary.dtos.customerDtos;

import gov.iti.jets.filmslibrary.dtos.addressDtos.AddressSetterDto;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement

public class CustomerSetterDto implements Serializable {

    private Short id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private Short storeId;
    private AddressSetterDto address;


}
