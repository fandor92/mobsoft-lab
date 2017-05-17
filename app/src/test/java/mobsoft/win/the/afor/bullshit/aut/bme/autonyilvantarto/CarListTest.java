package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.robolectric.annotation.Config;

import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.carlist.CarListScreen;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.RobolectricDaggerTestRunner;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CarListTest {

    private CarListPresenter carListPresenter;
    @Captor
    ArgumentCaptor<List<Car>> captor;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        setTestInjector();
        carListPresenter = new CarListPresenter();
    }

    @Test
    public void testGetDocuments() {
        CarListScreen screen = mock(CarListScreen.class);
        carListPresenter.attachScreen(screen);

        carListPresenter.getCars();

        verify(screen, times(1)).showCars(captor.capture());
        assertEquals(7, captor.getValue().size());
    }

    @After
    public void tearDown() {
        carListPresenter.detachScreen();
    }
}