package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository;

import android.content.Context;

import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;

public interface Repository {

    void open(Context context);

    void close();

    User getUser();

    void saveUser(User user);

    void deleteUser(User user);

    Car getCar(Long id);

    List<Car> getCars();

    void saveCar(Car car);

    void deleteCar(Car car);

    boolean isInDB(Car car);
}