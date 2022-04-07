package carRental;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.Scanner;


public class Starter {
    private static final String CONFIG_FILE_PATH = "config.properties";

    public static void main(String[] args) throws IOException{
        Rental rental = createCarRental();

        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);
        while (shouldContinue) {
            System.out.println("1. Add car");
            System.out.println("2. Display all cars");
            System.out.println("3. Rent a car");
            System.out.println("4. Return a car");
            System.out.println("5. Display available cars");
            System.out.println("6. Exit");

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> addCar(rental);
                case 2 -> rental.displayAllCars();
                case 3 -> rental.rentCar(readParameter("id"));
                case 4 -> rental.returnCar(readParameter("id"));
                case 5 -> rental.displayAvailableCars();
                default -> shouldContinue = false;
            }
        }
    }

    private static Rental createCarRental() throws IOException {
        Properties properties = new Properties();
        try (var fis = new FileInputStream(CONFIG_FILE_PATH)){
            properties.load(fis);
        }
        DataManager dataManager = new DataManager(new File(properties.getProperty("data.file")));
        Rental rental = new Rental(dataManager);
        return rental;
    }

    private static void addCar(Rental rental) {
        String id = readParameter("id");
        String manufacturer = readParameter("manufacturer");
        String model = readParameter("model");
        int productionYear = readYear("productionYear");
        Car car = new Car(id, manufacturer, model, productionYear);
        rental.addCar(car);
    }

    private static String readParameter(String parameter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + parameter + ": ");
        String value = scanner.nextLine();
        return value;
    }

    private static int readYear(String parameter) {
        Scanner scanner = new Scanner(System.in);
        Optional<Integer> year = Optional.empty();
        do {
            System.out.print("Enter " + parameter + ": ");
            try {
                year = Optional.of(Integer.valueOf(scanner.nextLine()));
            } catch (NumberFormatException e){
                System.out.println("Entered wrong year format, try again");
            }
        } while (year.isEmpty());
        return year.get();
    }
}