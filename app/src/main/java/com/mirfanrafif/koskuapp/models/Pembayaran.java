package com.mirfanrafif.koskuapp.models;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mirfanrafif.koskuapp.services.KoskuClient;
import com.mirfanrafif.koskuapp.services.PembayaranApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class Pembayaran {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("idanakkos")
    @Expose
    private AnakKos anakKos;
    @SerializedName("bulan")
    @Expose
    private Integer bulan;
    @SerializedName("tahun")
    @Expose
    private Integer tahun;
    @SerializedName("__v")
    @Expose
    private Integer v;

    PembayaranApi pembayaranApi = KoskuClient.createService(PembayaranApi.class);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AnakKos getAnakKos() {
        return anakKos;
    }

    public void setIdanakkos(AnakKos anakKos) {
        this.anakKos = anakKos;
    }

    public Integer getBulan() {
        return bulan;
    }

    public void setBulan(Integer bulan) {
        this.bulan = bulan;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public MutableLiveData<List<Pembayaran>> getAllPembayaran() {
        MutableLiveData<List<Pembayaran>> listPembayaran = new MutableLiveData<>();
        pembayaranApi.getAllPembayaran().enqueue(new Callback<List<Pembayaran>>() {
            @Override
            public void onResponse(Call<List<Pembayaran>> call, Response<List<Pembayaran>> response) {
                listPembayaran.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Pembayaran>> call, Throwable t) {
                Log.d("Pembayaran", "Error get Data : " + t.getMessage());
            }
        });
        return listPembayaran;
    }

}
