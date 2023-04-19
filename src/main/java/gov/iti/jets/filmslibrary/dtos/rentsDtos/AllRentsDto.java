package gov.iti.jets.filmslibrary.dtos.rentsDtos;

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

public class AllRentsDto implements Serializable {

    private Short customerId;
    private String customerName;
    private CustomerRentsGetterDto customerRentsGetterDto;
}
