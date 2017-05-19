package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.user.events;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;

/**
 * Created by andorfitos on 2017. 05. 16..
 */

public class LoginEvent {
    private int code;
    private User user;
    private Throwable throwable;
    private boolean success;

    public LoginEvent() {
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

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
