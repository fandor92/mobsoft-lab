package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist;

import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;

public interface CarListScreen {
    void showCars(List<Car> cars);

    void showFail(String message);
}