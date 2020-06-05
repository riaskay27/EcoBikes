import service.BikeServiceImpl;

public class StartApp {
    public static void main(String[] args) {
        BikeServiceImpl service=new BikeServiceImpl();
        System.out.println(service.findFirstByBrand("Freego"));
    }
}
