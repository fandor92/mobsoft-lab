package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events;

public class SaveUserEvent {
	private int code;
	private Throwable throwable;

	public SaveUserEvent() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}