package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.UIModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails.CarDetailsPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login.LoginPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.UiExecutor;

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }

    @Provides
    public CarDetailsPresenter provideCarDetailsPresenter() {
        return UIModule.provideCarDetailsPresenter();
    }

    @Provides
    public CarListPresenter provideCarListPresenter() {
        return UIModule.provideCarListPresenter();
    }

    @Provides
    public NewCarPresenter provideNewCarPresenter() {
        return UIModule.provideNewCarPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}