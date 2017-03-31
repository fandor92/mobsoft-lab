package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.main;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

/**
 * Created by Patrik on 2017. 03. 19..
 */

public class MainPresenter extends Presenter<MainScreen> {

    private static MainPresenter instance = null;

    private MainPresenter() {
    }

    public static MainPresenter getInstance() {
        if (instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}