package example.code.lastfm.model;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LastFMApiImpl {

    public static final String BASE_URL = "http://ws.audioscrobbler.com/";
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient;

    public static LastFMApi getLastFMApi() {

        if(okHttpClient == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        }

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .build();
        }

        LastFMApi lastFMApi = retrofit.create(LastFMApi.class);
        return lastFMApi;
    }
}
