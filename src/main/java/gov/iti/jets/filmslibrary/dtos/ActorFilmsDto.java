package gov.iti.jets.filmslibrary.dtos;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorFilmsDto implements Serializable {
    String actorName;

    List<String> films = new ArrayList<>();


}
