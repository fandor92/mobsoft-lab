package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.DeleteUserEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.GetUserEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.SaveUserEvent;
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

    public void getUser() {
        GetUserEvent event = new GetUserEvent();
        try {
            User user = repository.getUser();
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

	public void saveUser(User user) {
        SaveUserEvent event = new SaveUserEvent();
        try {
            repository.saveUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

	public void deleteUser(User user) {
        DeleteUserEvent event = new DeleteUserEvent();
        try {
            repository.deleteUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}