package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.UIModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails.CarDetailsActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login.LoginActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface AutonyilvantartoApplicationComponent {
    void inject(LoginActivity loginActivity);
    void inject(CarListActivity carListActivity);
    void inject(NewCarActivity newCarActivity);
    void inject(CarDetailsActivity carDetailsActivity);
}
