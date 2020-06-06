package entity;

import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoldingBike implements Bike {

    private String bikeType = "FOLDING BIKE";
    private String brand;
    private int sizeOfWheels;
    private int numOfGears;
    private int weight;
    private boolean availability;
    private String color;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoldingBike that = (FoldingBike) o;
        return sizeOfWheels == that.sizeOfWheels &&
                numOfGears == that.numOfGears &&
                weight == that.weight &&
                availability == that.availability &&
                price == that.price &&
                Objects.equals(bikeType, that.bikeType) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeType, brand, sizeOfWheels, numOfGears, weight, availability, color, price);
    }
}
