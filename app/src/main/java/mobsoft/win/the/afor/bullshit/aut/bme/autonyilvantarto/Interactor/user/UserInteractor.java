package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.Repository;

public class UserInteractor {

	@Inject
	Repository repository;
	@Inject
	EventBus bus;

	public UserInteractor() {
		AutonyilvantartoApplication.injector.inject(this);
	}

	public User getUser() {
		return repository.getUser();
	}

	public void saveUser(User user) {
		repository.saveUser(user);
	}

	public void deleteUser(User user) {
		repository.deleteUser(user);
	}
}