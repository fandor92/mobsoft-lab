package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;

public class MemoryRepository implements Repository {

	private static final long MINUTE = 60 * 1000;

	public static List<Car> cars;
	public User user = new User(1L, "password", "proba@email.hu");

	@Override
	public void open(Context context) {
		Car car1 = new Car(1L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
		Car car2 = new Car(2L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
		Car car3 = new Car(3L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
		Car car4 = new Car(4L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
		Car car5 = new Car(5L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
		Car car6 = new Car(6L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
		Car car7 = new Car(7L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");

		cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);
		cars.add(car6);
		cars.add(car7);
	}

	@Override
	public void close() {

	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void saveUser(User user) {
		this.user = user;
	}

	@Override
	public void deleteUser(User user) {
		this.user = null;
	}

	@Override
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

	@Override
	public List<Car> getCars() {
		return cars;
	}

	@Override
	public void saveCar(Car car) {
		if (car.getId() != null)
		{
			cars.set(cars.indexOf(getCar(car.getId())), car);
		}
		else
		{
			car.setId(cars.get(cars.size() - 1).getId() + 1);
			cars.add(car);
		}
	}

	@Override
	public void deleteCar(Car car) {
		cars.remove(car);
	}

	@Override
	public boolean isInDB(Car car) {
		return cars.contains(car);
	}

}