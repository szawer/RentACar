package carRental;

import java.util.HashMap;

public class Rental {
    private final DataManager dataManager;

    public Rental(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public void addCar(Car car){
        HashMap<String, Car> cars = loadCopyCars();
        cars.put(car.getId(), car);
        dataManager.saveCars(cars);
    }
    public void displayAllCars(){
        System.out.println("All cars:");
        for (Car car : loadCopyCars().values()){
            System.out.println(car);
        }
    }
    public void displayAvailableCars(){
        System.out.println("All available cars:");
        for (Car car : loadCopyCars().values()){
            if (!car.isBorrowed()){
                System.out.println(car);
            }
        }
    }

    public void rentCar(String id){
        HashMap<String, Car> cars = loadCopyCars();
        cars.get(id).setBorrowed(true);
        dataManager.saveCars(cars);
        System.out.println("Car id: " + id + " has been borrowed.");
    }
    public void returnCar(String id){
        HashMap<String, Car> cars = loadCopyCars();
        cars.get(id).setBorrowed(false);
        dataManager.saveCars(cars);
        System.out.println("Car id: " + id + " has been returned.");
    }
    private HashMap<String, Car> loadCopyCars(){
        return new HashMap<>(dataManager.loadCars());
    }
}
