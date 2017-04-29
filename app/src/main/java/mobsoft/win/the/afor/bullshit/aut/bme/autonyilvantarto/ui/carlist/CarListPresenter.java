package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.CarInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.GetCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.GetCarsEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication.injector;

public class CarListPresenter extends Presenter<CarListScreen> {

    @Inject
    CarInteractor carInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public CarListPresenter() {
    }

    @Override
    public void attachScreen(CarListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void getCars() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                carInteractor.getCars();
            }
        });
    }

    public void onEventMainThread(GetCarsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showFail("Could not get cars from database.");
            }
        } else {
            if (screen != null) {
                screen.showCars(event.getCars());
            }
        }
    }
}