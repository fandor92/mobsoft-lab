package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist;

import java.util.ArrayList;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

/**
 * Created by Patrik on 2017. 03. 19..
 */

public class CarListPresenter extends Presenter<CarListScreen> {

    public CarListPresenter() {
    }

    public void getCars()
    {
        screen.showCars(new ArrayList<String>());
    }

    @Override
    public void attachScreen(CarListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}