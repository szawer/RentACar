package CarRental;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Rental rental = new Rental();

        boolean shouldContinue = true;
        Scanner scanner = new Scanner(System.in);
        while (shouldContinue){
            System.out.println("1. Add car");
            System.out.println("2. Display all cars");
            System.out.println("3. Rent a car");
            System.out.println("4. Return a car");
            System.out.println("5. Display available cars");
            System.out.println("6. Exit");

            int userChoice = scanner.nextInt();
            switch (userChoice){
                case 1 -> addCar(rental);
                case 2 -> rental.displayAllCars();
                case 3 -> rental.rentCar(readParameter("id"));
                case 4 -> rental.returnCar(readParameter("id"));
                case 5 -> rental.displayAvailableCars();
                default -> shouldContinue = false;
            }
        }
    }

    private static void addCar(Rental rental) {
        String id = readParameter("id");
        String manufacturer = readParameter("manufacturer");
        String model = readParameter("model");
        String productionYear = readParameter("productionYear");
        Car car = new Car(id, manufacturer, model, Integer.valueOf(productionYear));
        rental.addCar(car);
    }

    private static String readParameter(String parameter){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + parameter +  ": " );
        String value = scanner.nextLine();
        System.out.println("Entered " + parameter + ":" + value);
        return value;
    }
    }
