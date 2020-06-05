package service;

import entity.FoldingBike;
import repository.BikeRepositoryImpl;
import java.io.IOException;
import java.util.function.Predicate;

public class BikeServiceImpl {
    private BikeRepositoryImpl repo;

    public BikeServiceImpl() {
        this.repo = new BikeRepositoryImpl();
    }

    public void showCatalog(){
        repo.getBikes();
    }

    public void addFoldingBike(String foldingBike){
        repo.getBikes().add(foldingBike);
    }

    public void addSpeedelec(String speedelec){
        repo.getBikes().add(speedelec);
    }

    public void addEbike(String ebike){
        repo.getBikes().add(ebike);
    }

    public String findFirstByBrand(String brand){
        return repo.getBikes().stream().filter(s-> s.contains(brand)).findFirst().get();
    }

    public void writeToFile() throws IOException {
        repo.writeToFile(repo.getBikes());
    }
}
