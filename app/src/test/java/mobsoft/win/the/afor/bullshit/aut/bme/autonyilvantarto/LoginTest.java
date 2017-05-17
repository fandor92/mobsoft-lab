package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login.LoginPresenter;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.login.LoginScreen;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.RobolectricDaggerTestRunner;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginTest {

    private LoginPresenter loginPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        loginPresenter = new LoginPresenter();
    }

    @Test
    public void testLogin() {
        LoginScreen loginScreen = mock(LoginScreen.class);
        loginPresenter.attachScreen(loginScreen);
        loginPresenter.doLogin("asd", "asd");

        verify(loginScreen, times(1)).loginSucceeded("Login succeeded");
    }

    @After
    public void tearDown() {
        loginPresenter.detachScreen();
    }
}