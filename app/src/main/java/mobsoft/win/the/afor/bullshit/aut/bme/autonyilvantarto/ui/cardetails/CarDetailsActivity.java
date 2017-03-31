package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.R;

public class CarDetailsActivity extends AppCompatActivity implements CarDetailsScreen {

    @Inject
    CarDetailsPresenter carDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutonyilvantartoApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        carDetailsPresenter.attachScreen(this);
        carDetailsPresenter.getCar(1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        carDetailsPresenter.detachScreen();
    }

    @Override
    public void showDetails(String details) {

    }

    @Override
    public void showDeleteSuccessPopup(String message) {

    }

    @Override
    public void showDeleteFailPopup(String message) {

    }


}
