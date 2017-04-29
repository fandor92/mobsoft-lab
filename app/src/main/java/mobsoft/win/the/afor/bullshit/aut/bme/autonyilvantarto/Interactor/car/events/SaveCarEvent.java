package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events;

public class SaveCarEvent {
    private int code;
    private Throwable throwable;

    public SaveCarEvent() {
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