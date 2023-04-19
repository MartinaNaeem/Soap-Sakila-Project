package gov.iti.jets.filmslibrary.dtos.rentsDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class RentalSetterDto implements Serializable {
    private Integer inventoryId;
    private Short customerId;
    private Short staffId;


}
