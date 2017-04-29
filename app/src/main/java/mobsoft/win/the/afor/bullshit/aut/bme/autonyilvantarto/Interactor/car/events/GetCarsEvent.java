package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events;

import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;

public class GetCarsEvent {
    private int code;
    private List<Car> cars;
    private Throwable throwable;

    public GetCarsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}