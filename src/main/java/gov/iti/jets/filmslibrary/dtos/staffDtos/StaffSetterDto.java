package gov.iti.jets.filmslibrary.dtos.staffDtos;

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
public class StaffSetterDto implements Serializable {
    private Short staffId;
    private String firstName;
    private String lastName;
//    private byte[] picture;
    private String email;
    private boolean active;
    private String username;
    private String password;
    private Short storeId;

    private AddressSetterDto address;
}
