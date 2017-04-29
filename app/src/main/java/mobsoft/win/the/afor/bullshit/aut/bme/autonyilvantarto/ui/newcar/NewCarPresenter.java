package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.CarInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.GetCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.SaveCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication.injector;

public class NewCarPresenter extends Presenter<NewCarScreen> {

    @Inject
    CarInteractor carInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public NewCarPresenter() {
    }

    @Override
    public void attachScreen(NewCarScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void saveCar(final Car car) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                carInteractor.saveCar(car);
            }
        });
    }

    public void getCar(final long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                carInteractor.getCar(id);
            }
        });
    }

    public void onEventMainThread(GetCarEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showFail("Could not get car from database.");
            }
        } else {
            if (screen != null) {
                screen.fillValues(event.getCar());
            }
        }
    }

    public void onEventMainThread(SaveCarEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showFail("Could not save car to database.");
            }
        } else {
            if (screen != null) {
                screen.showSuccess("Successfully saved car.");
            }
        }
    }
}