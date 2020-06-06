package view;

public class View {

    public void printMenu() {

        System.out.println(
                "Please, make your choice:\n" +
                        "1-Show the entire EcoBike catalog\n" +
                        "2 – Add a new folding bike\n" +
                        "3 – Add a new speedelec\n" +
                        "4 – Add a new e-bike\n" +
                        "5 – Find the first item of a particular brand\n" +
                        "6 – Write to file\n" +
                        "7 – Stop the program"
        );
    }

    public void set(String setter) {
        System.out.println("Please,set " + setter + "\n");
    }


    public void addSpeedelec() {
        System.out.println(
                "Please, enter parameters of SPEEDELEC(\n" +
                        "- A brand\n" +
                        "- The maximum speed (in km/h)\n" +
                        "- The weight of the bike (in grams) \n" +
                        "- The availability of lights at front and back (TRUE/FALSE)\n" +
                        "- The battery capacity (in mAh)\n" +
                        "- A color\n" +
                        "- The price)\n " +
                        "(example: Booster; 35; 10900; false; 13200; green; 1279):\n"

        );
    }

    public void addEbike() {
        System.out.println(
                "Please, enter parameters of E-BIKE(\n" +
                        "- A brand\n" +
                        "- The maximum speed (in km/h)\n" +
                        "- The weight of the bike (in grams) \n" +
                        "- The availability of lights at front and back (TRUE/FALSE)\n" +
                        "- The battery capacity (in mAh)\n" +
                        "- A color\n" +
                        "- The price)\n " +
                        "(example: Lankeleisi; 65; 24200; false; 10000; black; 2399):\n"

        );
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printTrueAvailabilityRes(String bikeType, String brand, int batteryCapacity, int price) {
        System.out.println(bikeType + " " + brand + " with " + batteryCapacity + " mAh battery and head/tail light. \nPrice: " + price + " euros\n");
    }

    public void printNoTrueAvailabilityRes(String bikeType, String brand, int batteryCapacity, int price) {
        System.out.println(bikeType + " " + brand + " with " + batteryCapacity + " mAh battery and no head/tail light. \nPrice: " + price + " euros\n");
    }

    public void printTrueAvailabilityResF(String bikeType, String brand, int numOfGears, int price) {
        System.out.println(bikeType + " " + brand + " with " + numOfGears + " gear(s) and head/tail light.  \nPrice: " + price + " euros\n");
    }

    public void printNoTrueAvailabilityResF(String bikeType, String brand, int numOfGears, int price) {
        System.out.println(bikeType + " " + brand + " with " + numOfGears + " gear(s) and no head/tail light.  \nPrice: " + price + " euros\n");
    }
}
