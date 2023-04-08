package gov.iti.jets.filmslibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSetterDto implements Serializable {

    short id;
    String firstName;
    String lastName;
    String email;
    String address;
    String address2;

    String city;
    short country;
    String phone;
    boolean active;

    String postalCode;
    String district;

    short storeId;


}
