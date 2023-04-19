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
public class StoreInventoryGetterDto implements Serializable {
    private Integer inventoryId;
    private Short filmId;
    private String filmTitle;
}
