package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.DeleteCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.GetCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.GetCarsEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events.SaveCarEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api.CarApi;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.Repository;

public class CarInteractor {

	@Inject
	Repository repository;
	@Inject
	EventBus bus;
    @Inject
    CarApi carApi;

	public CarInteractor() {
		AutonyilvantartoApplication.injector.inject(this);
	}

	public void getCar(Long id) {
		GetCarEvent event = new GetCarEvent();
		try {
			Car car = repository.getCar(id);
			event.setCar(car);
			bus.post(event);
		} catch (Exception e) {
			event.setThrowable(e);
			bus.post(event);
		}
	}

	public void getCars() {
		GetCarsEvent event = new GetCarsEvent();
		try {
            carApi.carGet().execute();
            List<Car> cars = repository.getCars();
			event.setCars(cars);
			bus.post(event);
		} catch (Exception e) {
			event.setThrowable(e);
			bus.post(event);
		}
	}

	public void saveCar(Car car) {
		SaveCarEvent event = new SaveCarEvent();
		try {
			repository.saveCar(car);
			bus.post(event);
		} catch (Exception e) {
			event.setThrowable(e);
			bus.post(event);
		}
	}

	public void deleteCar(Car car) {
		DeleteCarEvent event = new DeleteCarEvent();
		try {
			repository.deleteCar(car);
			bus.post(event);
		} catch (Exception e) {
			event.setThrowable(e);
			bus.post(event);
		}
	}

}