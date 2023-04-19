package gov.iti.jets.filmslibrary.dtos.staffDtos;

import gov.iti.jets.filmslibrary.model.Address;
import gov.iti.jets.filmslibrary.model.Payment;
import gov.iti.jets.filmslibrary.model.Rental;
import gov.iti.jets.filmslibrary.model.Store;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class StaffGetterDto implements Serializable {
    private Short staffId;
    private String fullName;
    private byte[] picture;
    private String email;
    private boolean active;
    private String username;
    private Short addressId;
    private String address;
    private Short storeId;
}
