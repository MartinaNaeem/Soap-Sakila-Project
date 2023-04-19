package gov.iti.jets.filmslibrary.dtos.cityDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class CityGetterDto implements Serializable {
    private Short cityId;
    private String city;
    private Short countryId;
    private String country;
}
