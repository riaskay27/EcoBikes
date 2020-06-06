import controller.BikeController;
import service.BikeServiceImpl;
import view.View;

public class StartApp {
    public static void main(String[] args) {
        BikeServiceImpl service = new BikeServiceImpl();
        View view = new View();
        BikeController controller = new BikeController(service, view, System.in);
        controller.startApp();
    }
}
