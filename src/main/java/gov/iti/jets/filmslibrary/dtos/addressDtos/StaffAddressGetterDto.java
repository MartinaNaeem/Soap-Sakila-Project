package gov.iti.jets.filmslibrary.dtos.addressDtos;

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
public class StaffAddressGetterDto implements Serializable {
    private Short staffId;
    private String staffName;
}
