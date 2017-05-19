package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.AutonyilvantartoApplication;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.DeleteUserEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.GetUserEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.LoginEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events.SaveUserEvent;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api.UserApi;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.Repository;
import retrofit2.Response;

public class UserInteractor {

	@Inject
	Repository repository;
	@Inject
	EventBus bus;
    @Inject
    UserApi userApi;

	public UserInteractor() {
		AutonyilvantartoApplication.injector.inject(this);
	}

    public void login(final String username, final String password) {
        LoginEvent event = new LoginEvent();
        try {
            Response<Void> response = userApi.userLoginGet().execute();
            event.setSuccess(response.isSuccess());
            if (response.isSuccess()) {
                User user = new User();
                user.setEmail(username);
                user.setPassword(password);
                event.setUser(user);
            }
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
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

    public void deleteUser() {
        DeleteUserEvent event = new DeleteUserEvent();
        try {
            repository.deleteUser(repository.getUser());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}