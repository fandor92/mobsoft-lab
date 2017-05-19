package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class Car {

    @SerializedName("id")
    private Long id = null;

    @SerializedName("plateNumber")
    private String plateNumber = null;

    @SerializedName("mileage")
    private Integer mileage = null;

    @SerializedName("engineCapacity")
    private Integer engineCapacity = null;

    @SerializedName("year")
    private Integer year = null;

    @SerializedName("brand")
    private String brand = null;

    @SerializedName("fuel")
    private String fuel = null;

    @SerializedName("type")
    private String type = null;


    /**
     **/
    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(plateNumber, car.plateNumber) &&
                Objects.equals(mileage, car.mileage) &&
                Objects.equals(engineCapacity, car.engineCapacity) &&
                Objects.equals(year, car.year) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(fuel, car.fuel) &&
                Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNumber, mileage, engineCapacity, year, brand, fuel, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Car {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    plateNumber: ").append(toIndentedString(plateNumber)).append("\n");
        sb.append("    mileage: ").append(toIndentedString(mileage)).append("\n");
        sb.append("    engineCapacity: ").append(toIndentedString(engineCapacity)).append("\n");
        sb.append("    year: ").append(toIndentedString(year)).append("\n");
        sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
        sb.append("    fuel: ").append(toIndentedString(fuel)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
