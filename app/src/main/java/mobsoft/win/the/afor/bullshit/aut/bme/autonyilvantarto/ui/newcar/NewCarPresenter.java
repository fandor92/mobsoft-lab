package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

/**
 * Created by Patrik on 2017. 03. 19..
 */

public class NewCarPresenter extends Presenter<NewCarScreen> {

    public NewCarPresenter() {
    }

    public void newCar(int id)
    {
        if (id > -1)
        {
            editCar(id);
        }
        else
        {
            if(true)
            {
                screen.showSuccessfulCreate("sikeres létrehozás");
            }
            else
            {
                screen.showFailedCreate("sikertelen létrehozás");
            }
        }
    }

    private void editCar(int id) {
        if (true)
        {
            screen.showSuccessfulEdit("sikeres szerkesztés");
        }
        else
        {
            screen.showFailedulEdit("sikertelen szerkesztés");
        }
    }


    @Override
    public void attachScreen(NewCarScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}