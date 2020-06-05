package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Speedelec {
    enum Color {
        WHITE,
        BLACK,
        RED,
        BLUE
    }
    private String bikeType="SPEEDELEC";
    private String brand;
    private int maxSpeed;
    private int weight;
    private boolean availability;
    private int batteryCapacity;
    private Color color;
    private int price;
}
