package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;

public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public Car getCar(Long id) {
        return SugarRecord.findById(Car.class, id);
    }

    @Override
    public List<Car> getCars() {
        return null;
    }

    @Override
    public void saveCar(Long id) {

    }

    @Override
    public void updateCar(Long id) {

    }

    @Override
    public void deleteCar(Long id) {

    }

    @Override
    public boolean isInDB(Car car) {
        return SugarRecord.findById(Car.class, car.getId()) != null;
    }
}