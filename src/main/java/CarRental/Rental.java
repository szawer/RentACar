package CarRental;

import java.util.HashMap;

public class Rental {
    private HashMap<String,Car> cars = new HashMap<>();

    public void addCar(Car car){
        cars.put(car.getId(), car);
    }
    public void displayAllCars(){
        System.out.println("All cars:");
        for (Car car : cars.values()){
            System.out.println(car);
        }
    }
    public void displayAvailableCars(){
        System.out.println("All available cars:");
        for (Car car : cars.values()){
            if (!car.isBorrowed()){
                System.out.println(car);
            }
        }
    }

    public void rentCar(String id){
        cars.get(id).setBorrowed(true);
        System.out.println("Car id: " + id + " has been borrowed.");
    }
    public void returnCar(String id){
        cars.get(id).setBorrowed(false);
        System.out.println("Car id: " + id + " has been returned.");
    }
}
