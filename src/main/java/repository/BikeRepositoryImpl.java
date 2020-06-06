package repository;

import entity.Bike;
import entity.Ebike;
import entity.FoldingBike;
import entity.Speedelec;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Setter
@Getter
@ToString
public class BikeRepositoryImpl implements BikeRepository {
    private List<Bike> bikes;


    public BikeRepositoryImpl() {
        this.bikes = parseToObject();
    }

    public List<String> readFile() {
        String fileName = "C:\\Users\\1\\IdeaProjects\\EcoBike\\src\\main\\resources\\ecobike.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile() throws IOException {
        String fileName = "C:\\Users\\1\\IdeaProjects\\EcoBike\\src\\main\\resources\\ecobike.txt";

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Bike obj :
                bikes) {
            if (obj.toString().contains("E-BIKE")) {
                Ebike ebike = (Ebike) obj;
                printWriter.printf(ebike.getBikeType()
                        + " "
                        + ebike.getBrand() + "; "
                        + ebike.getMaxSpeed()
                        + "; "
                        + ebike.getWeight()
                        + "; "
                        + ebike.isAvailability()
                        + "; "
                        + ebike.getBatteryCapacity()
                        + "; "
                        + ebike.getColor()
                        + "; "
                        + ebike.getPrice() + "\n"
                );
            }
            if (obj.toString().contains("SPEEDELEC")) {
                Speedelec speedelec = (Speedelec) obj;
                printWriter.printf(speedelec.getBikeType()
                        + " "
                        + speedelec.getBrand() + "; "
                        + speedelec.getMaxSpeed()
                        + "; "
                        + speedelec.getWeight()
                        + "; "
                        + speedelec.isAvailability()
                        + "; "
                        + speedelec.getBatteryCapacity()
                        + "; "
                        + speedelec.getColor()
                        + "; "
                        + speedelec.getPrice() + "\n"
                );
            }
            if (obj.toString().contains("FOLDING BIKE")) {
                FoldingBike foldingBike = (FoldingBike) obj;
                printWriter.printf(foldingBike.getBikeType()
                        + " "
                        + foldingBike.getBrand() + "; "
                        + foldingBike.getSizeOfWheels()
                        + "; "
                        + foldingBike.getNumOfGears()
                        + "; "
                        + foldingBike.getWeight()
                        + "; "
                        + foldingBike.isAvailability()
                        + "; "
                        + foldingBike.getColor()
                        + "; "
                        + foldingBike.getPrice() + "\n"
                );
            }

        }
        printWriter.close();

    }


    public List<Bike> parseToObject() {
        List<String> lines = readFile();
        List<Bike> bikes = new ArrayList<>();
        for (String str :
                lines) {
            if (str.contains("FOLDING BIKE")) {
                int separator1 = str.indexOf(' ');
                int separator2 = str.indexOf(';');
                String brand = str.substring(str.indexOf(' ', separator1 + 1) + 1, separator2);
                String trimStr = str.substring(str.indexOf(';', separator2) + 2);
                String[] arr = trimStr.split("; ");
                FoldingBike foldingBike = FoldingBike.builder()
                        .bikeType("FOLDING BIKE")
                        .brand(brand)
                        .sizeOfWheels(Integer.parseInt(arr[0]))
                        .numOfGears(Integer.parseInt(arr[1]))
                        .weight(Integer.parseInt(arr[2]))
                        .availability(Boolean.parseBoolean(arr[3]))
                        .color(arr[4])
                        .price(Integer.parseInt(arr[5]))
                        .build();
                bikes.add(foldingBike);
            }
            if (str.contains("SPEEDELEC")) {
                int separator1 = str.indexOf(' ');
                int separator2 = str.indexOf(';');
                String brand = str.substring(separator1, separator2);
                String trimStr = str.substring(str.indexOf(';', separator2) + 2);
                String[] arr = trimStr.split("; ");
                Speedelec speedelec = Speedelec.builder()
                        .bikeType("SPEEDELEC")
                        .brand(brand)
                        .maxSpeed(Integer.parseInt(arr[0]))
                        .weight(Integer.parseInt(arr[1]))
                        .availability(Boolean.parseBoolean(arr[2]))
                        .batteryCapacity(Integer.parseInt(arr[3]))
                        .color(arr[4])
                        .price(Integer.parseInt(arr[5]))
                        .build();
                bikes.add(speedelec);
            }
            if (str.contains("E-BIKE")) {
                int separator1 = str.indexOf(' ');
                int separator2 = str.indexOf(';');
                String brand = str.substring(separator1, separator2);
                String trimStr = str.substring(str.indexOf(';', separator2) + 2);
                String[] arr = trimStr.split("; ");
                Ebike ebike = Ebike.builder()
                        .bikeType("E-BIKE")
                        .brand(brand)
                        .maxSpeed(Integer.parseInt(arr[0]))
                        .weight(Integer.parseInt(arr[1]))
                        .availability(Boolean.parseBoolean(arr[2]))
                        .batteryCapacity(Integer.parseInt(arr[3]))
                        .color(arr[4])
                        .price(Integer.parseInt(arr[5]))
                        .build();
                bikes.add(ebike);
            }
        }
        return bikes;
    }
}
