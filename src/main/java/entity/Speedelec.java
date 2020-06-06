package entity;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Speedelec implements Bike {

    private String bikeType = "SPEEDELEC";
    private String brand;
    private int maxSpeed;
    private int weight;
    private boolean availability;
    private int batteryCapacity;
    private String color;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speedelec speedelec = (Speedelec) o;
        return maxSpeed == speedelec.maxSpeed &&
                weight == speedelec.weight &&
                availability == speedelec.availability &&
                batteryCapacity == speedelec.batteryCapacity &&
                price == speedelec.price &&
                Objects.equals(bikeType, speedelec.bikeType) &&
                Objects.equals(brand, speedelec.brand) &&
                Objects.equals(color, speedelec.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeType, brand, maxSpeed, weight, availability, batteryCapacity, color, price);
    }
}
