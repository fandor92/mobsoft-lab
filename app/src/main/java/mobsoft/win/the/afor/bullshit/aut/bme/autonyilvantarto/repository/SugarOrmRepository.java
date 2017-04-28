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
        SugarRecord.saveInTx(user);
    }

    @Override
    public void deleteUser(User user) {
        SugarRecord.deleteInTx(user);
    }

    @Override
    public Car getCar(Long id) {
        return SugarRecord.findById(Car.class, id);
    }

    @Override
    public List<Car> getCars() {
        return SugarRecord.listAll(Car.class);
    }

    @Override
    public void saveCar(Car car) {
        SugarRecord.saveInTx(car);
    }

    @Override
    public void deleteCar(Car car) {
        SugarRecord.deleteInTx(car);
    }

    @Override
    public boolean isInDB(Car car) {
        return SugarRecord.findById(Car.class, car.getId()) != null;
    }
}