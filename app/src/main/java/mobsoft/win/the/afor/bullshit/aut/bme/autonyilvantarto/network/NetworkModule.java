package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api.CarApi;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api.UserApi;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public CarApi provideACarApi(Retrofit retrofit) {
        return retrofit.create(CarApi.class);
    }

    @Provides
    @Singleton
    public UserApi provideAUserApi(Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }
}
