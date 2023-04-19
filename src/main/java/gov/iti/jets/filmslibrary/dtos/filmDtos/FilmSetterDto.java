package gov.iti.jets.filmslibrary.dtos.filmDtos;


import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement

public class FilmSetterDto implements Serializable {

    private Short filmId;
    private String title;
    private String description;
    private Integer releaseYear;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private List<Short> actors;
    private Short languageId;
    private Short originalLanguageId;
    private List<EmbeddedInventoryDto> inventoryList;
    private Short category;
}
