package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events;

public class DeleteCarEvent {
    private int code;
    private Throwable throwable;

    public DeleteCarEvent() {
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