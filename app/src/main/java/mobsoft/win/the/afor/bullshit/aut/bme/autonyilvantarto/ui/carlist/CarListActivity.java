package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.R;

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
    }

    @Override
    protected void onStop() {
        super.onStop();
        carListPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
