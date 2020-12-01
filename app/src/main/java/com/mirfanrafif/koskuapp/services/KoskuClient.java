package com.mirfanrafif.koskuapp.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KoskuClient {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://kosku-service.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
