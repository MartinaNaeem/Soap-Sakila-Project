package gov.iti.jets.filmslibrary.dtos.customerDtos;

import gov.iti.jets.filmslibrary.dtos.rentsDtos.CustomerRentsGetterDto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlList;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement

public class CustomerGetterDto implements Serializable {
    private Short id;
    private Short addressId;
    private String name;
    private String email;
    private String address;
    private byte[] location;
    private String country;
    private String city;
    private String phone;
    private String postalCode;
    private Date createDate;
    private Boolean active;
    private List<CustomerRentsGetterDto> customerRentsGetterDtoList;
}
