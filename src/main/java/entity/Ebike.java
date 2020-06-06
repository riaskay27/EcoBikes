package entity;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Ebike implements Bike {

    private String bikeType = "E-BIKE";
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
        Ebike ebike = (Ebike) o;
        return maxSpeed == ebike.maxSpeed &&
                weight == ebike.weight &&
                availability == ebike.availability &&
                batteryCapacity == ebike.batteryCapacity &&
                price == ebike.price &&
                Objects.equals(bikeType, ebike.bikeType) &&
                Objects.equals(brand, ebike.brand) &&
                Objects.equals(color, ebike.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeType, brand, maxSpeed, weight, availability, batteryCapacity, color, price);
    }
}
