package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;

public interface NewCarScreen {
    void fillValues(Car car);

    void showSuccess(String message);

    void showFail(String message);
}