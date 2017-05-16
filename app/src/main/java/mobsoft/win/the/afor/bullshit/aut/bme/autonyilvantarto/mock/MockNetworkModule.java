package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.NetworkModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api.CarApi;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.network.api.UserApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public UserApi provideUserApi(Retrofit retrofit) {
        return networkModule.provideAUserApi(retrofit);
    }

    @Provides
    @Singleton
    public CarApi provideCarApi(Retrofit retrofit) {
        return networkModule.provideACarApi(retrofit);
    }

}