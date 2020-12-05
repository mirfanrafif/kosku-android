package com.mirfanrafif.koskuapp.services;

import com.mirfanrafif.koskuapp.models.Pembayaran;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PembayaranApi {
    @GET("pembayaran")
    Call<List<Pembayaran>> getAllPembayaran();
}
