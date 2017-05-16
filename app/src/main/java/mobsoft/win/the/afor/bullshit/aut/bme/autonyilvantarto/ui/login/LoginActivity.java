package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.R;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListActivity;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AutonyilvantartoApplication.injector.inject(this);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        final EditText emailInput = (EditText) findViewById(R.id.emailInput);
        final EditText passwordInput = (EditText) findViewById(R.id.passwordInput);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.doLogin(emailInput.getText().toString(), passwordInput.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
        loginPresenter.isUserLoggedIn();
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    public void login()
    {
        loginPresenter.doLogin("username","password");
    }

    @Override
    public void loginSucceeded(String text) {
        Intent carListIntent = new Intent(LoginActivity.this, CarListActivity.class);
        startActivity(carListIntent);
        finish();
    }

    @Override
    public void loginError(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
