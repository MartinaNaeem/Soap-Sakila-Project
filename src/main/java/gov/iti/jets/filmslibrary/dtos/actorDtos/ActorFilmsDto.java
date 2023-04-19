package gov.iti.jets.filmslibrary.dtos.actorDtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class ActorFilmsDto implements Serializable {
    String actorName;
    List<String> films = new ArrayList<>();


}
