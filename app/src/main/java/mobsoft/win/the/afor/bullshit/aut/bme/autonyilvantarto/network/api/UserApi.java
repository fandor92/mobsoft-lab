package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    /**
     * Logs user into the system
     *
     * @return Call<Void>
     */

    @GET("user/login")
    Call<Void> userLoginGet();


}
