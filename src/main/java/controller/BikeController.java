package controller;

import entity.Bike;
import entity.Ebike;
import entity.FoldingBike;
import entity.Speedelec;
import service.BikeServiceImpl;
import view.View;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class BikeController {
    private BikeServiceImpl service;
    private View view;
    private InputStream in;

    public BikeController(BikeServiceImpl service, View view, InputStream in) {
        this.service = service;
        this.view = view;
        this.in = in;
    }

    public void startApp() {
        view.printMenu();
        try (Scanner reader = new Scanner(new InputStreamReader(in, "UTF-8"))) {
            while (true) {
                String userLine = reader.nextLine();
                switch (userLine) {
                    case ("1"):
                        List<Bike> fromFile = service.showCatalog();
                        for (Bike obj :
                                fromFile) {
                            if (obj.toString().contains("E-BIKE")) {
                                Ebike ebike = (Ebike) obj;
                                if (ebike.isAvailability()) {
                                    view.printTrueAvailabilityRes(ebike.getBikeType(), ebike.getBrand(), ebike.getBatteryCapacity(), ebike.getPrice());
                                } else {
                                    view.printNoTrueAvailabilityRes(ebike.getBikeType(), ebike.getBrand(), ebike.getBatteryCapacity(), ebike.getPrice());
                                }
                            }
                            if (obj.toString().contains("SPEEDELEC")) {
                                Speedelec speedelec = (Speedelec) obj;
                                if (speedelec.isAvailability()) {
                                    view.printTrueAvailabilityRes(speedelec.getBikeType(), speedelec.getBrand(), speedelec.getBatteryCapacity(), speedelec.getPrice());
                                } else {
                                    view.printNoTrueAvailabilityRes(speedelec.getBikeType(), speedelec.getBrand(), speedelec.getBatteryCapacity(), speedelec.getPrice());
                                }
                            }
                            if (obj.toString().contains("FOLDING BIKE")) {
                                FoldingBike foldingBike = (FoldingBike) obj;
                                if (foldingBike.isAvailability()) {
                                    view.printTrueAvailabilityResF(foldingBike.getBikeType(), foldingBike.getBrand(), foldingBike.getNumOfGears(), foldingBike.getPrice());
                                } else {
                                    view.printNoTrueAvailabilityResF(foldingBike.getBikeType(), foldingBike.getBrand(), foldingBike.getNumOfGears(), foldingBike.getPrice());
                                }
                            }
                        }
                        view.printMenu();
                        break;
                    case ("2"):
                        String f_type = "FOLDING BIKE";
                        view.set("Brand");
                        String f_brand = reader.nextLine();
                        view.set("Size of wheels (in inch)");
                        int f_sizeOfWheels = Integer.parseInt(reader.nextLine());
                        view.set("The number of gears");
                        int f_numOfGears = Integer.parseInt(reader.nextLine());
                        view.set("The weight of the bike (in grams)");
                        int f_weight = Integer.parseInt(reader.nextLine());
                        view.set("Availability of lights at front and back (TRUE/FALSE) :");
                        boolean f_availability = Boolean.parseBoolean(reader.nextLine());
                        view.set("A Color:");
                        String f_color = reader.nextLine();
                        view.set("The Price:");
                        int f_price = Integer.parseInt(reader.nextLine());
                        FoldingBike foldingBike = new FoldingBike(f_type, f_brand, f_sizeOfWheels, f_numOfGears, f_weight, f_availability, f_color, f_price);
                        service.addFoldingBike(foldingBike);
                        view.printMenu();
                        break;
                    case ("3"):
                        String s_type = "SPEEDELEC";
                        view.set("Brand");
                        String s_brand = reader.nextLine();
                        view.set("The maximum speed (in km/h) ");
                        int s_max_speed = Integer.parseInt(reader.nextLine());
                        view.set("The weight of the bike (in grams)");
                        int s_weight = Integer.parseInt(reader.nextLine());
                        view.set("Availability of lights at front and back (TRUE/FALSE) :");
                        boolean s_availability = Boolean.parseBoolean(reader.nextLine());
                        view.set("The battery capacity (in mAh) ");
                        int s_battery = Integer.parseInt(reader.nextLine());
                        view.set("A Color:");
                        String s_color = reader.nextLine();
                        view.set("The Price:");
                        int s_price = Integer.parseInt(reader.nextLine());
                        Speedelec speedelec = new Speedelec(s_type, s_brand, s_max_speed, s_weight, s_availability, s_battery, s_color, s_price);
                        service.addSpeedelec(speedelec);
                        view.printMenu();
                        break;
                    case ("4"):
                        String e_type = "E-BIKE";
                        view.set("Brand");
                        String e_brand = reader.nextLine();
                        view.set("The maximum speed (in km/h) ");
                        int e_max_speed = Integer.parseInt(reader.nextLine());
                        view.set("The weight of the bike (in grams)");
                        int e_weight = Integer.parseInt(reader.nextLine());
                        view.set("Availability of lights at front and back (TRUE/FALSE) :");
                        boolean e_availability = Boolean.parseBoolean(reader.nextLine());
                        view.set("The battery capacity (in mAh) ");
                        int e_battery = Integer.parseInt(reader.nextLine());
                        view.set("A Color:");
                        String e_color = reader.nextLine();
                        view.set("The Price:");
                        int e_price = Integer.parseInt(reader.nextLine());
                        Ebike ebike = new Ebike(e_type, e_brand, e_max_speed, e_weight, e_availability, e_battery, e_color, e_price);
                        service.addEbike(ebike);
                        view.printMenu();
                        break;
                    case ("5"):
                        view.set("particular brand: ");
                        String part_brand = reader.nextLine();
                        view.printResult(service.findFirstByBrand(part_brand));
                        view.printMenu();
                        break;
                    case ("6"):
                        service.writeToFile();
                        view.printMenu();
                        break;
                    case ("7"):
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
