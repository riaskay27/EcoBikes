package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoldingBike {
    enum Color {
        WHITE,
        BLACK,
        RED,
        BLUE
    }
    private String bikeType="FOLDING BIKE";
    private String brand;
    private int sizeOfWheels;
    private int numOfGears;
    private int weight;
    private boolean availability;
    private Color color;
    private int price;
}
