package gov.iti.jets.filmslibrary.dtos.inventoryDtos;

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
public class InventorySetterDto implements Serializable {
    private Integer inventoryId;
    private Short filmId;
    private Short storeId;
}
