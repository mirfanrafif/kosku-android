package com.mirfanrafif.koskuapp.services;

import com.mirfanrafif.koskuapp.models.Pembayaran;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface PembayaranApi {
    @GET("pembayaran")
    Call<List<Pembayaran>> getAllPembayaran();

    @POST("pembayaran")
    Call<Pembayaran> savePembayaran(@Body Pembayaran pembayaran);

    @GET("pembayaran/{id}")
    Call<Pembayaran> getById(@Path("id") String id);
}
