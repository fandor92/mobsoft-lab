package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.R;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListActivity;

public class NewCarActivity extends AppCompatActivity implements NewCarScreen {

    @Inject
    NewCarPresenter newCarPresenter;

    EditText plateNumber;
    EditText mileage;
    EditText engine;
    EditText year;
    Spinner brand;
    Spinner fuel;
    Spinner type;
    Button saveButton;

    Long carId;
    String plateNumberIntent;
    int mileageIntent;
    int engineIntent;
    int yearIntent;
    String brandIntent;
    String fuelIntent;
    String typeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcar);
        AutonyilvantartoApplication.injector.inject(this);

        plateNumber = (EditText) findViewById(R.id.plateNumberText);
        mileage = (EditText) findViewById(R.id.mileageText);
        engine = (EditText) findViewById(R.id.engineText);
        year = (EditText) findViewById(R.id.yearText);
        brand = (Spinner) findViewById(R.id.brandSpinner);
        fuel = (Spinner) findViewById(R.id.fuelSpinner);
        type = (Spinner) findViewById(R.id.typeSpinner);

        ArrayAdapter<CharSequence> brandsAdapter = ArrayAdapter.createFromResource(this,
                R.array.brands_array, android.R.layout.simple_spinner_item);
        brandsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand.setAdapter(brandsAdapter);

        ArrayAdapter<CharSequence> fuelAdapter = ArrayAdapter.createFromResource(this,
                R.array.fuel_array, android.R.layout.simple_spinner_item);
        fuelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuel.setAdapter(fuelAdapter);

        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(typeAdapter);

        if (this.getIntent().getExtras() != null) {
            carId = this.getIntent().getExtras().getLong("id");
            plateNumberIntent = this.getIntent().getExtras().getString("plateNumber");
            mileageIntent = this.getIntent().getExtras().getInt("mileage");
            engineIntent = this.getIntent().getExtras().getInt("engine");
            yearIntent = this.getIntent().getExtras().getInt("year");
            brandIntent = this.getIntent().getExtras().getString("brand");
            fuelIntent = this.getIntent().getExtras().getString("fuel");
            typeIntent = this.getIntent().getExtras().getString("type");
        }

        if ((carId != null) && (plateNumberIntent != null) && (mileageIntent != 0) && (engineIntent != 0) && (yearIntent != 0) && (brandIntent != null) && (fuelIntent != null) && (typeIntent != null)) {
            plateNumber.setText(plateNumberIntent);
            mileage.setText(String.valueOf(mileageIntent));
            engine.setText(String.valueOf(engineIntent));
            year.setText(String.valueOf(yearIntent));
            int brandPosition = brandsAdapter.getPosition(brandIntent);
            brand.setSelection(brandPosition);
            int fuelPosition = fuelAdapter.getPosition(fuelIntent);
            fuel.setSelection(fuelPosition);
            int typePosition = typeAdapter.getPosition(typeIntent);
            type.setSelection(typePosition);
        }


        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car car = new Car();
                if (carId != null)
                    car.setId(carId);

                car.setBrand(brand.getSelectedItem().toString());
                car.setEngineCapacity(Integer.parseInt(engine.getText().toString()));
                car.setFuel(fuel.getSelectedItem().toString());
                car.setMileage(Integer.parseInt(mileage.getText().toString()));
                car.setPlateNumber(plateNumber.getText().toString());
                car.setType(type.getSelectedItem().toString());
                car.setYear(Integer.parseInt(year.getText().toString()));
                newCarPresenter.saveCar(car);
            }
        });
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
    public void fillValues(Car car) {

    }

    @Override
    public void showSuccess(String message) {
        Intent carListIntent = new Intent(NewCarActivity.this, CarListActivity.class);
        startActivity(carListIntent);
    }

    @Override
    public void showFail(String message) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_new_car, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout: {
                newCarPresenter.logout();
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
