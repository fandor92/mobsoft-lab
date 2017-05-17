package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.robolectric.annotation.Config;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.newcar.NewCarScreen;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.RobolectricDaggerTestRunner;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class NewCarTest {

    private NewCarPresenter newCarPresenter;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        setTestInjector();
        newCarPresenter = new NewCarPresenter();
    }

    @Test
    public void testSaveCar() {
        NewCarScreen screen = mock(NewCarScreen.class);
        newCarPresenter.attachScreen(screen);

        Car car = new Car(null, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        newCarPresenter.saveCar(car);

        verify(screen, times(1)).showSuccess("Successfully saved car.");
    }

    @Test
    public void testModifyCarFill() {
        ArgumentCaptor<Car> captor = ArgumentCaptor.forClass(Car.class);
        NewCarScreen screen = mock(NewCarScreen.class);
        newCarPresenter.attachScreen(screen);

        newCarPresenter.getCar(1);

        verify(screen, times(1)).fillValues(captor.capture());
    }

    @Test
    public void testModifyCarSave() {
        ArgumentCaptor<Car> captor = ArgumentCaptor.forClass(Car.class);
        NewCarScreen screen = mock(NewCarScreen.class);
        newCarPresenter.attachScreen(screen);

        Car car = new Car(1L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        newCarPresenter.saveCar(car);

        verify(screen, times(1)).showSuccess("Successfully saved car.");
    }

    @Test
    public void testModifyCarSaveError() {
        NewCarScreen screen = mock(NewCarScreen.class);
        newCarPresenter.attachScreen(screen);
        Car car = new Car(60000L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        newCarPresenter.saveCar(car);

        verify(screen, times(1)).showFail("Could not save car to database.");
    }

    @After
    public void tearDown() {
        newCarPresenter.detachScreen();
    }
}