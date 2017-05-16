package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import android.app.Application;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.Repository;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.UIModule;

public class AutonyilvantartoApplication extends Application {

	@Inject
	Repository repository;

	public static AutonyilvantartoApplicationComponent injector;

    public void setInjector(AutonyilvantartoApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

	@Override
	public void onCreate() {
		super.onCreate();

		injector =
				DaggerAutonyilvantartoApplicationComponent.builder().
						uIModule(
								new UIModule(this)
						).build();
		injector.inject(this);
		repository.open(getApplicationContext());
	}
}