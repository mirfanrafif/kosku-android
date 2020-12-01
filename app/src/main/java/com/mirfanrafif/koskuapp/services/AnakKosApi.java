package com.mirfanrafif.koskuapp.services;

import com.mirfanrafif.koskuapp.models.AnakKos;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AnakKosApi {
    @GET("anakkos")
    Call<List<AnakKos>> getAllAnakKos();
}
