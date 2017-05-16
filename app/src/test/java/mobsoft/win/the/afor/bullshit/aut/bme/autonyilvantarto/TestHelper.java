package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        AutonyilvantartoApplication application = (AutonyilvantartoApplication) RuntimeEnvironment.application;
        AutonyilvantartoApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}