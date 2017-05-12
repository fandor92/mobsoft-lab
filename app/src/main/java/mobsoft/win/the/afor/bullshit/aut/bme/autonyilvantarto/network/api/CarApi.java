package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api;

import java.util.List;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.model.Car;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CarApi {

    /**
     * Get the cars of the user
     *
     * @return Call<List<Car>>
     */

    @GET("car")
    Call<List<Car>> carGet();


    /**
     * Create a new car for the user
     *
     * @param body
     * @return Call<Void>
     */

    @POST("car")
    Call<Void> carPost(
            @Body Car body
    );


    /**
     * Get a car by id.
     *
     * @param id ID of the car
     * @return Call<Car>
     */

    @GET("car/{id}")
    Call<Car> carIdGet(
            @Path("id") Long id
    );


    /**
     * Update a car by id
     *
     * @param id   ID of the car
     * @param body
     * @return Call<Void>
     */

    @PUT("car/{id}")
    Call<Void> carIdPut(
            @Path("id") Long id, @Body Car body
    );


    /**
     * Delete a car by id
     *
     * @param id ID of the car
     * @return Call<Void>
     */

    @DELETE("car/{id}")
    Call<Void> carIdDelete(
            @Path("id") Long id
    );


}
