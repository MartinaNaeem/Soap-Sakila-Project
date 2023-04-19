package gov.iti.jets.filmslibrary.dtos.filmDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Builder
public class EmbeddedInventoryDto implements Serializable {
    private Integer inventoryId;
    private Short storeId;

}
