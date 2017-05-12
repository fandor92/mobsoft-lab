package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock.interceptors;

import android.net.Uri;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.model.User;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.NetworkConfig;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock.interceptors.MockHelper.makeResponse;

public class UserMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());
        User user = new User(1L, "asd", "asd");

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "user/login") && request.method().equals("Get")) {
            User postedUser = GsonHelper.getGson().fromJson(request.body().toString(), User.class);
            if (postedUser.getEmail().equals(user.getEmail()) && postedUser.getPassword().equals(user.getPassword())) {
                responseString = "Ok";
                responseCode = 200;
            } else {
                responseString = "Invalid username/password";
                responseCode = 401;
            }

        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}