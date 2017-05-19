package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.Repository;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.UIModule;

public class AutonyilvantartoApplication extends Application {

	private static GoogleAnalytics sAnalytics;
	private static Tracker sTracker;

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
		sAnalytics = GoogleAnalytics.getInstance(this);

		injector =
				DaggerAutonyilvantartoApplicationComponent.builder().
						uIModule(
								new UIModule(this)
						).build();
		injector.inject(this);
		repository.open(getApplicationContext());
	}

	/**
	 * Gets the default {@link Tracker} for this {@link Application}.
	 *
	 * @return tracker
	 */
	synchronized public Tracker getDefaultTracker() {
		// To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
		if (sTracker == null) {
			sTracker = sAnalytics.newTracker(R.xml.global_tracker);
		}

		return sTracker;
	}
}