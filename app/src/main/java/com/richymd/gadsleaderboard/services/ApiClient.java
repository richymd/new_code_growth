package com.richymd.gadsleaderboard.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    private static HttpLoggingInterceptor logger =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder okHttp =
            new OkHttpClient.Builder().addInterceptor(logger);

    private static Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttp.build());

    private static Retrofit retrofit = builder.build();

    public static <retro> retro buildApiService(Class<retro> serviceType) {
        return retrofit.create(serviceType);
    }
}
