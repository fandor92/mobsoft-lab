package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.R;

public class NewCarActivity extends AppCompatActivity implements NewCarScreen {

    @Inject
    NewCarPresenter newCarPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutonyilvantartoApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        newCarPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        newCarPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessfulCreate(String s) {

    }

    @Override
    public void showFailedCreate(String s) {

    }

    @Override
    public void showSuccessfulEdit(String s) {

    }

    @Override
    public void showFailedulEdit(String s) {

    }
}
