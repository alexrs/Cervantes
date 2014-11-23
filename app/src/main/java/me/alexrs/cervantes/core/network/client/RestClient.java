package me.alexrs.cervantes.core.network.client;

import com.squareup.okhttp.OkHttpClient;
import me.alexrs.cervantes.core.network.api.NebrijaApi;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * @author Alejandro on 23/11/14.
 *         http://inaka.net/blog/2014/10/10/android-retrofit-rest-client/
 */
public class RestClient {

  private static NebrijaApi REST_CLIENT;
  private static String URL = "http://dulcinea.herokuapp.com/";

  static {
    setupRestClient();
  }

  private RestClient() {
  }

  public static NebrijaApi get() {
    return REST_CLIENT;
  }

  private static void setupRestClient() {
    RestAdapter.Builder builder = new RestAdapter.Builder().setEndpoint(URL)
        .setClient(new OkClient(new OkHttpClient()))
        .setLogLevel(RestAdapter.LogLevel.FULL);

    RestAdapter restAdapter = builder.build();
    REST_CLIENT = restAdapter.create(NebrijaApi.class);
  }
}
