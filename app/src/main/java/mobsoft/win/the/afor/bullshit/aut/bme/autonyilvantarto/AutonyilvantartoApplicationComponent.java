package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.InteractorModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.CarInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.UserInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.RepositoryModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.UIModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails.CarDetailsActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails.CarDetailsPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login.LoginActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login.LoginPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarPresenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface AutonyilvantartoApplicationComponent {
    void inject(LoginActivity loginActivity);
    void inject(CarListActivity carListActivity);
    void inject(NewCarActivity newCarActivity);
    void inject(CarDetailsActivity carDetailsActivity);

    void inject(LoginPresenter loginPresenter);

    void inject(CarListPresenter carListPresenter);

    void inject(NewCarPresenter newCarPresenter);

    void inject(CarDetailsPresenter carDetailsPresenter);

    void inject(UserInteractor userInteractor);
    void inject(CarInteractor carInteractor);
    void inject(AutonyilvantartoApplication autonyilvantartoApplication);
}
