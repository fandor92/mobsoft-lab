package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock.interceptors;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.Car;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.NetworkConfig;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock.interceptors.MockHelper.makeResponse;

public class CarMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());
        String responseString;
        int responseCode;
        Headers headers = request.headers();

        Car car1 = new Car(1L, "ASD-123", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        Car car2 = new Car(2L, "ASD-567", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        Car car3 = new Car(3L, "ASD-789", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        Car car4 = new Car(4L, "ASD-321", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        Car car5 = new Car(5L, "ASD-654", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        Car car6 = new Car(6L, "ASD-987", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");
        Car car7 = new Car(7L, "ASD-198", 1000, 1800, 2007, "Honda", "Petrol", "Sedan");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "car") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "car") && request.method().equals("Get")) {
            responseString = GsonHelper.getGson().toJson(cars);
            responseCode = 200;
        } else if (uri.getPath().matches("\\" + NetworkConfig.ENDPOINT_PREFIX + "car\\/" + "\\d+") && request.method().equals("Get")) {
            long id = Long.parseLong(uri.getPath().substring(uri.getPath().lastIndexOf("/")));

            Car returnCar = null;
            for (Car currentCar : cars) {
                if (currentCar.getId().equals(id)) {
                    returnCar = currentCar;
                }
            }

            if (returnCar != null) {
                responseString = GsonHelper.getGson().toJson(returnCar);
                responseCode = 200;
            } else {
                responseString = "";
                responseCode = 404;
            }

        } else if (uri.getPath().matches("\\" + NetworkConfig.ENDPOINT_PREFIX + "todo\\/" + "\\d+") && request.method().equals("Put")) {

            responseString = "Ok";
            responseCode = 200;
        } else if (uri.getPath().matches("\\" + NetworkConfig.ENDPOINT_PREFIX + "todo\\/" + "\\d+") && request.method().equals("Delete")) {

            responseString = "Ok";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}