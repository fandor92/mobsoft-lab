package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock;

import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}