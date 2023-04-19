package gov.iti.jets.filmslibrary.dtos.rentsDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement

public class CustomerRentsGetterDto implements Serializable {

    private Integer rentalId;
    private Date rentalDate;
    private Date returnDate;
    private Integer inventoryId;
    private Short filmId;
    private String filmTitle;
    private Short storeId;
    private List<CustomerPaymentGetterDto> customerPaymentGetterDtoList;
}
