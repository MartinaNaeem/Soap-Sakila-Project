package gov.iti.jets.filmslibrary.dtos.filmDtos;


import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@XmlRootElement

public class FilmGetterDto implements Serializable {


    private short fid;
    private String title;
    private String description;
    private String category;
    private Short length;
    private String rating;
    private List<String> actors;
    private Integer releaseYear;
    private String language;
    private BigDecimal rentalRate;
    private Byte rentalDuration;
    private BigDecimal replacementCost;
    private List<String> specialFeature;
    private Date lastUpdate;
    private List<EmbeddedInventoryDto> inventoriesList;

}
