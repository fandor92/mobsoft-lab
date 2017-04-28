package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.Repository;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.MemoryRepository.cars;

public class CarInteractor {

	@Inject
	Repository repository;
	@Inject
	EventBus bus;

	public CarInteractor() {
		AutonyilvantartoApplication.injector.inject(this);
	}

	public Car getCar(Long id) {
		for (Car currentCar:cars)
		{
			if (currentCar.getId().equals(id))
			{
				return currentCar;
			}
		}
		return null;
	}

	public List<Car> getCars() {
		return repository.getCars();
	}

	public void saveCar(Car car) {
		repository.saveCar(car);
	}

	public void deleteCar(Car car) {
		repository.deleteCar(car);
	}

	public boolean isInDB(Car car) {
		return repository.isInDB(car);
	}
}