package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.robolectric.annotation.Config;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails.CarDetailsPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.cardetails.CarDetailsScreen;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.RobolectricDaggerTestRunner;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CarDetailsTest {

    private CarDetailsPresenter carDetailsPresenter;


    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        setTestInjector();
        carDetailsPresenter = new CarDetailsPresenter();
    }

    @Test
    public void testGetCar() {
        CarDetailsScreen screen = mock(CarDetailsScreen.class);
        carDetailsPresenter.attachScreen(screen);
        ArgumentCaptor<Car> captor = ArgumentCaptor.forClass(Car.class);


        carDetailsPresenter.getCar(2);

        verify(screen, times(1)).showDetails(captor.capture());
        assertEquals("ASD-123", captor.getValue().getPlateNumber());
        assertEquals(1000, captor.getValue().getMileage().intValue());
        assertEquals(1800, captor.getValue().getEngineCapacity().intValue());
        assertEquals(2007, captor.getValue().getYear().intValue());
        assertEquals("Honda", captor.getValue().getBrand());
        assertEquals("Petrol", captor.getValue().getFuel());
        assertEquals("Sedan", captor.getValue().getType());
    }

    @Test
    public void testDeleteCar() {
        CarDetailsScreen screen = mock(CarDetailsScreen.class);
        carDetailsPresenter.attachScreen(screen);

        Car car = new Car(3L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");

        carDetailsPresenter.deleteCar(car);

        verify(screen, times(1)).showSuccess("Successfully deleted car from database.");
    }

    @After
    public void tearDown() {
        carDetailsPresenter.detachScreen();
    }
}