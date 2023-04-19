package gov.iti.jets.filmslibrary.dtos.actorDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ActorGetterDto implements Serializable {
    private Short actorId;
    private String firstName;
    private String lastName;
    private List<ActorFilmGetterDto> actorFilmGetterDtoList;
}
