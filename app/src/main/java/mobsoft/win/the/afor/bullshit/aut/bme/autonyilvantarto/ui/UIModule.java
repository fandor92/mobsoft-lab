package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails.CarDetailsPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login.LoginPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarPresenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public CarListPresenter provideCarListPresenter() {
        return new CarListPresenter();
    }

    @Provides
    @Singleton
    public NewCarPresenter provideNewCarPresenter() {
        return new NewCarPresenter();
    }

    @Provides
    @Singleton
    public CarDetailsPresenter provideCarDetailsPresenter() {
        return new CarDetailsPresenter();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }
}
