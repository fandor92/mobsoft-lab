package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

/**
 * Created by Patrik on 2017. 03. 19..
 */

public class CarDetailsPresenter extends Presenter<CarDetailsScreen> {

    public CarDetailsPresenter() {
    }

    public void getCar(int id)
    {
        screen.showDetails("asd");
    }

    public void deleteCar(int id)
    {
        if (true)
        {
            screen.showDeleteSuccessPopup("sikeres törlés");
        }
        else
        {
            screen.showDeleteFailPopup("sikertelen törlés");
        }
    }

    @Override
    public void attachScreen(CarDetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}