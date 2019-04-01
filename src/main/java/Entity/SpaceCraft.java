package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceCraft {
    private String  name;
    private int yearMade;
    private int capacity;
    private double fuel;
}
