package gov.iti.jets.filmslibrary.dtos.addressDtos;


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
public class AddressSetterDto implements Serializable {
    private Short addressId;
    private String address;
    private String address2;
    private Byte [] location;
    private String city;
    private Short country;
    private String phone;
    private String postalCode;
    private String district;
}
