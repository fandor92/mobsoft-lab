package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;

public interface CarDetailsScreen {
    void showDetails(Car car);

    void showSuccess(String message);

    void showFail(String message);
}