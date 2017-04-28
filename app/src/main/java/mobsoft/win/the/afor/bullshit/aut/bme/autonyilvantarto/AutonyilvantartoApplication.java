package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import android.app.Application;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.UIModule;

public class AutonyilvantartoApplication extends Application {

	public static AutonyilvantartoApplicationComponent injector;

	@Override
	public void onCreate() {
		super.onCreate();

		injector =
				DaggerAutonyilvantartoApplicationComponent.builder().
						uIModule(
								new UIModule(this)
						).build();
	}
}