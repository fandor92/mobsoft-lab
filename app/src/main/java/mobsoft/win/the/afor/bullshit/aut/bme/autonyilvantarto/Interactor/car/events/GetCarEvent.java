package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.car.events;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;

public class GetCarEvent {
	private int code;
	private Car car;
	private Throwable throwable;

	public GetCarEvent() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

}