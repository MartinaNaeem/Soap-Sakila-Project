package gov.iti.jets.filmslibrary.dtos.filmDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement

public class FilmFilterDto implements Serializable {
    private Short fid;
    private String category;
    private String language;
    private String rate;
    private String title;
    private BigDecimal minReplacementCost;
    private  BigDecimal maxReplacementCost;
    private  BigDecimal minRentalRate;
    private BigDecimal maxRentalRate;
    private Integer releaseYear;

}
