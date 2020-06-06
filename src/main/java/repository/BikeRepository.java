package repository;


import java.io.IOException;
import java.util.List;

public interface BikeRepository {
    List<String> readFile();

    void writeToFile() throws IOException;
}
