package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car;

import android.accounts.NetworkErrorException;

import java.util.ArrayList;
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
import retrofit2.Response;

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
			if (car == null) {
				Response<mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model.Car> res = carApi.carIdGet(id).execute();
				mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model.Car carFromNetwork = res.body();
				car = new Car();
				car.setYear(carFromNetwork.getYear());
				car.setType(carFromNetwork.getType());
				car.setPlateNumber(carFromNetwork.getPlateNumber());
				car.setBrand(carFromNetwork.getBrand());
				car.setEngineCapacity(carFromNetwork.getEngineCapacity());
				car.setFuel(carFromNetwork.getFuel());
				car.setMileage(carFromNetwork.getMileage());
			}
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
			List<Car> cars = repository.getCars();
			if (cars == null || cars.size() == 0) {
				cars = new ArrayList<Car>();
				Response<List<mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model.Car>> response = carApi.carGet().execute();
				if (response.isSuccess()) {
					for (mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model.Car carFromNetwork : response.body()) {
						Car car = new Car();
						car.setYear(carFromNetwork.getYear());
						car.setType(carFromNetwork.getType());
						car.setPlateNumber(carFromNetwork.getPlateNumber());
						car.setBrand(carFromNetwork.getBrand());
						car.setEngineCapacity(carFromNetwork.getEngineCapacity());
						car.setFuel(carFromNetwork.getFuel());
						car.setMileage(carFromNetwork.getMileage());
						cars.add(car);
						repository.saveCar(car);
					}
				} else {
					throw new NetworkErrorException();
				}
			}
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
			mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model.Car carToPost = new mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model.Car();
			carToPost.setYear(car.getYear());
			carToPost.setType(car.getType());
			carToPost.setPlateNumber(car.getPlateNumber());
			carToPost.setBrand(car.getBrand());
			carToPost.setEngineCapacity(car.getEngineCapacity());
			carToPost.setFuel(car.getFuel());
			carToPost.setMileage(car.getMileage());
			Response res = carApi.carPost(carToPost).execute();
			if (res.isSuccess()) {
				repository.saveCar(car);
			}
			bus.post(event);
		} catch (Exception e) {
			event.setThrowable(e);
			bus.post(event);
		}
	}

	public void deleteCar(Car car) {
		DeleteCarEvent event = new DeleteCarEvent();
		try {
			Response res = carApi.carIdDelete(car.getId()).execute();
			if (res.isSuccess()) {
				repository.deleteCar(car);
			}
			bus.post(event);
		} catch (Exception e) {
			event.setThrowable(e);
			bus.post(event);
		}
	}

}