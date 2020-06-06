package service;

import java.io.IOException;

public interface BikeService {

    void showCatalog();

    void addFoldingBike(String foldingBike);

    void addSpeedelec(String speedelec);

    void addEbike(String ebike);

    String findFirstByBrand(String brand);

    void writeToFile() throws IOException;

}
