package com.example.network_activities.login.network;

import android.content.Context;

import com.example.network_activities.login.APIInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    static RetrofitClient retrofitClient;
    private final Retrofit retrofit;

    private RetrofitClient(Context context, String baseUrl) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://htadminserviceapi-dev.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public static RetrofitClient getInstance(Context context, String baseUrl) {
        retrofitClient = new RetrofitClient(context, baseUrl);
        return retrofitClient;
    }

    public APIInterface getRetrofitAPI() {
        return retrofit.create(APIInterface.class);
    }


}
