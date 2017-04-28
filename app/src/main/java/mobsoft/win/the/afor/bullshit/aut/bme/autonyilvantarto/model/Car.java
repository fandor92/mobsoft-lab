package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model;

import com.orm.dsl.Table;

@Table
public class Car {
    private Long id = null;
    private String plateNumber;
    private Integer mileage;
    private Integer engineCapacity;
    private Integer year;
    private String brand;
    private String fuel;
    private String type;

    public Car() {
    }

    public Car(Long id, String plateNumber, Integer mileage, Integer engineCapacity, Integer year, String brand, String fuel, String type) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
        this.year = year;
        this.brand = brand;
        this.fuel = fuel;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}