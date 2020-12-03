package com.mirfanrafif.koskuapp.services;

import com.mirfanrafif.koskuapp.models.AnakKos;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AnakKosApi {
    @GET("anakkos")
    Call<List<AnakKos>> getAllAnakKos();

    @POST("anakkos")
    Call<AnakKos> saveAnakKos(@Body AnakKos anakKos);

    @GET("anakkos/{id}")
    Call<List<AnakKos>> getAnakKosById(@Path("id") String id);
}
