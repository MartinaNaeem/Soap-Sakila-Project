package gov.iti.jets.filmslibrary.dtos.storeDtos;


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
public class StoreCustomerGetterDto implements Serializable {
    private Short customerId;
    private String customerName;
}
