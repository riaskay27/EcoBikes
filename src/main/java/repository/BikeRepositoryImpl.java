package repository;

import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Setter
@Getter
public class BikeRepositoryImpl implements BikeRepository{
    private List<String> bikes;

    public BikeRepositoryImpl() {
        this.bikes = readFile();
    }

    public List<String> readFile() {
        String fileName="C:\\Users\\1\\IdeaProjects\\EcoBike\\src\\main\\resources\\ecobike.txt";
        try(Stream<String> stream = Files.lines(Paths.get(fileName))){
            return stream.collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile(List<String> bikesCatalog) throws IOException {
        String fileName="C:\\Users\\1\\IdeaProjects\\EcoBike\\src\\main\\resources\\ecobike.txt";
        FileWriter fileWriter = new FileWriter(fileName,false);
        for (String line:
            bikesCatalog ) {
            fileWriter.write(line+System.lineSeparator());
        }
        fileWriter.close();
    }
}
