package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private String description;
    private SpaceCraft shuttle;
    private List<Astronaut> astronauts;
    private double duration;
    private int distance;
}
