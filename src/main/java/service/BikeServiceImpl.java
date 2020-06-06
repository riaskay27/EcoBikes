package service;

import entity.Bike;
import repository.BikeRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class BikeServiceImpl {
    private BikeRepositoryImpl repo;

    public BikeServiceImpl() {
        this.repo = new BikeRepositoryImpl();
    }

    public List<Bike> showCatalog() {
        return repo.getBikes();
    }

    public void addFoldingBike(Bike foldingBike) {
        repo.getBikes().add(foldingBike);
    }

    public void addSpeedelec(Bike speedelec) {
        repo.getBikes().add(speedelec);
    }

    public void addEbike(Bike ebike) {
        repo.getBikes().add(ebike);
    }

    public String findFirstByBrand(String brand) {
        return repo.getBikes().stream().map(bike -> bike.toString()).filter(b -> b.contains(brand)).findFirst().get();
    }

    public void writeToFile() throws IOException {
        repo.writeToFile();
    }
}
