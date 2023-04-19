package gov.iti.jets.filmslibrary.dtos.inventoryDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class InventoryGetterDto implements Serializable {
    private Integer inventoryId;
    private Short filmId;
    private String filmTitle;
    private Short storeId;


}
