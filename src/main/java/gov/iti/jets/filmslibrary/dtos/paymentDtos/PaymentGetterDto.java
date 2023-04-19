package gov.iti.jets.filmslibrary.dtos.paymentDtos;

import gov.iti.jets.filmslibrary.model.*;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement

public class PaymentGetterDto implements Serializable {

    private Short paymentId;

    private BigDecimal amount;

    private Date paymentDate;

    private Short customerId;
    private String customerName;
    private Integer rentalId;
    private Date rentalDate;
    private Date returnDate;
    private Integer inventoryId;
    private Short filmId;
    private String filmTitle;
    private Short staffId;
    private String staffName;
}
