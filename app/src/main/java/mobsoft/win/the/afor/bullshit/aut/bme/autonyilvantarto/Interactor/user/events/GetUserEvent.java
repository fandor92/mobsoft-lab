package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;

public class GetUserEvent {
	private int code;
	private User user;
	private Throwable throwable;

	public GetUserEvent() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}