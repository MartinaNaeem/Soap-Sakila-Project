package gov.iti.jets.filmslibrary.dtos.paymentDtos;

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

public class PaymentSetterDto implements Serializable {
    private BigDecimal amount;
    private Short customerId;
    private Integer rentalId;
    private Short staffId;
}
