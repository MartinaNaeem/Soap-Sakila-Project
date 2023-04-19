package gov.iti.jets.filmslibrary.dtos.actorDtos;


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
public class ActorFilmGetterDto implements Serializable {
    private String filmTitle;
    private Short filmId;
}
