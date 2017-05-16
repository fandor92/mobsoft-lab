package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.CarInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.DeleteCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.GetCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.SaveCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.UserInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.Presenter;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication.injector;

public class CarDetailsPresenter extends Presenter<CarDetailsScreen> {

    @Inject
    CarInteractor carInteractor;

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public CarDetailsPresenter() {
    }

    @Override
    public void attachScreen(CarDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        bus.unregister(this);
    }

    public void getCar(final long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                carInteractor.getCar(id);
            }
        });
    }

    public void deleteCar(final Car car) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                carInteractor.deleteCar(car);
            }
        });
    }

    public void logout() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.deleteUser();
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
                screen.showDetails(event.getCar());
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
                screen.showSuccess("Successfully saved car to database.");
            }
        }
    }

    public void onEventMainThread(DeleteCarEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showFail("Could not delete car from database.");
            }
        } else {
            if (screen != null) {
                screen.showSuccess("Successfully deleted car from database.");
            }
        }
    }
}