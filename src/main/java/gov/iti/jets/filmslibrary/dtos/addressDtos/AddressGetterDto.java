package gov.iti.jets.filmslibrary.dtos.addressDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class AddressGetterDto implements Serializable {
    private Short addressId;
    private String address;
    private String address2;
    private byte [] location;
    private String city;
    private Short cityId;
    private String country;
    private Short countryId;
    private String phone;
    private String postalCode;
    private String district;
    List<CustomerAddressGetterDto> customers;
    List<Short> stores;
    List<StaffAddressGetterDto> staff;
}
