package gov.iti.jets.filmslibrary.dtos.rentsDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement

public class CustomerPaymentGetterDto implements Serializable {
    private Short paymentId;
    private BigDecimal amount;
    private Date paymentDate;
}
