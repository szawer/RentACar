package CarRental;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String id;
    private String manufacturer;
    private String model;
    private int productionYear;
    private boolean borrowed = false;

    public Car(String id, String manufacturer, String model, int productionYear) {
        this(id,manufacturer,model,productionYear,false);
    }
    @JsonCreator
    public Car(@JsonProperty("id")String id,
               @JsonProperty("manufacturer") String manufacturer,
               @JsonProperty("model") String model,
               @JsonProperty("productionYear") int productionYear,
               @JsonProperty("borrowed") boolean borrowed) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.borrowed = borrowed;

    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", borrowed=" + borrowed +
                '}';
    }
}

