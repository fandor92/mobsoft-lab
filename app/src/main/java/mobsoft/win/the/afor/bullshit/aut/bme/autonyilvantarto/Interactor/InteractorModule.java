package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor;

import dagger.Module;
import dagger.Provides;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.CarInteractor;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.UserInteractor;

@Module
public class InteractorModule {


	@Provides
	public UserInteractor provideUser() {
		return new UserInteractor();
	}

	@Provides
	public CarInteractor provideCar() {
		return new CarInteractor();
	}
}