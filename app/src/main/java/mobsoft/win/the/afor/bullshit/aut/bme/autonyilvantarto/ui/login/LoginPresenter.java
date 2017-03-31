package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

/**
 * Created by Patrik on 2017. 03. 19..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    public LoginPresenter() {
    }

    public void doLogin(String userName, String password)
    {
        if (true)
        {
            screen.loginSucceeded("sikerült");
        }
        else
        {
            screen.loginError("nem sikerült");
        }
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}