package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.UserInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.SaveUserEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication.injector;

/**
 * Created by Patrik on 2017. 03. 19..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public LoginPresenter() {
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void doLogin(final String userName, final String password) {
        if (true) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    User user = new User(null, userName, password);
                    userInteractor.saveUser(user);
                }
            });
        } else {
            screen.loginError("Error, something bad happened.");
        }
    }

    public void onEventMainThread(SaveUserEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.loginError("Could not login.");
            }
        } else {
            if (screen != null) {
                screen.loginSucceeded("Login succeeded");
            }
        }
    }
}