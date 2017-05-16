package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.R;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListActivity;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarActivity;

public class CarDetailsActivity extends AppCompatActivity implements CarDetailsScreen {

    @Inject
    CarDetailsPresenter carDetailsPresenter;

    TextView plateNumber;
    TextView mileage;
    TextView engine;
    TextView year;
    TextView brand;
    TextView fuel;
    TextView type;
    Long carId;
    Car currentCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardetails);
        AutonyilvantartoApplication.injector.inject(this);
        plateNumber = (TextView) findViewById(R.id.plateNumberTV);
        mileage = (TextView) findViewById(R.id.mileageTV);
        engine = (TextView) findViewById(R.id.engineTV);
        year = (TextView) findViewById(R.id.yearTV);
        brand = (TextView) findViewById(R.id.brandTV);
        fuel = (TextView) findViewById(R.id.fuelTV);
        type = (TextView) findViewById(R.id.typeTV);
        carId = this.getIntent().getExtras().getLong("id");
    }

    @Override
    protected void onStart() {
        super.onStart();
        carDetailsPresenter.attachScreen(this);
        carDetailsPresenter.getCar(carId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        carDetailsPresenter.detachScreen();
    }

    @Override
    public void showDetails(Car car) {

        currentCar = car;

        if (car.getPlateNumber() != null)
            plateNumber.setText(car.getPlateNumber());

        if (car.getMileage() != null)
            mileage.setText(car.getMileage().toString());

        if (car.getEngineCapacity() != null)
            engine.setText(car.getEngineCapacity().toString());

        if (car.getYear() != null)
            year.setText(car.getYear().toString());

        if (car.getBrand() != null)
            brand.setText(car.getBrand());

        if (car.getFuel() != null)
            fuel.setText(car.getFuel());

        if (car.getType() != null)
            type.setText(car.getType());
    }

    @Override
    public void showSuccess(String message) {

    }

    @Override
    public void showFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_car_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editCar: {
                Intent newIntent = new Intent(CarDetailsActivity.this, NewCarActivity.class);
                newIntent.putExtra("id", carId);
                newIntent.putExtra("plateNumber", plateNumber.getText().toString());
                newIntent.putExtra("mileage", Integer.parseInt(mileage.getText().toString()));
                newIntent.putExtra("engine", Integer.parseInt(engine.getText().toString()));
                newIntent.putExtra("year", Integer.parseInt(year.getText().toString()));
                newIntent.putExtra("brand", brand.getText().toString());
                newIntent.putExtra("fuel", fuel.getText().toString());
                newIntent.putExtra("type", type.getText().toString());

                startActivity(newIntent);
                break;
            }
            case R.id.deleteCar: {
                carDetailsPresenter.deleteCar(currentCar);
                Intent newIntent = new Intent(CarDetailsActivity.this, CarListActivity.class);

                startActivity(newIntent);
                break;
            }
            case R.id.logout: {
                carDetailsPresenter.logout();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
