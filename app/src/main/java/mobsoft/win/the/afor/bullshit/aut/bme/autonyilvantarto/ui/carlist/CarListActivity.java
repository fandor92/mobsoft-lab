package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.R;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;

public class CarListActivity extends AppCompatActivity implements CarListScreen {

    @Inject
    CarListPresenter carListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutonyilvantartoApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        carListPresenter.attachScreen(this);
        carListPresenter.getCars();
    }

    @Override
    protected void onStop() {
        super.onStop();
        carListPresenter.detachScreen();
    }

    @Override
    public void showCars(List<Car> cars)
    {

    }

    @Override
    public void showFail(String message) {

    }
}
