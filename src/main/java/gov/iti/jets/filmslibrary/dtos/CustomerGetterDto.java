package gov.iti.jets.filmslibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerGetterDto implements Serializable {
    short id;
    String name;
    String email;
    String address;
    String country;
    String city;
    String notes;
    String phone;
    String zipcode;
}
