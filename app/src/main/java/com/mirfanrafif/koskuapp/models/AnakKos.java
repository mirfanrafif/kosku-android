package com.mirfanrafif.koskuapp.models;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mirfanrafif.koskuapp.services.AnakKosApi;
import com.mirfanrafif.koskuapp.services.KoskuClient;
import com.mirfanrafif.koskuapp.ui.anakkos.AnakKosItemViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AnakKos {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("asal")
    @Expose
    private String asal;
    @SerializedName("nohp")
    @Expose
    private String nohp;
    @SerializedName("__v")
    @Expose
    private Integer v;

    private AnakKosApi anakKosApi;

    public AnakKos() {
        anakKosApi = KoskuClient.createService(AnakKosApi.class);
    }

    public AnakKos(String id, String nama, String asal, String nohp, Integer v, AnakKosApi anakKosApi) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.nohp = nohp;
        this.v = v;
        this.anakKosApi = anakKosApi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public MutableLiveData<List<AnakKos>> getListAnakKos() {
        MutableLiveData<List<AnakKos>> listAnakKos = new MutableLiveData<>();
        anakKosApi.getAllAnakKos().enqueue(new Callback<List<AnakKos>>() {
            @Override
            public void onResponse(Call<List<AnakKos>> call, Response<List<AnakKos>> response) {
                Log.d("VMData", "Uda lewat sini lho");
                listAnakKos.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AnakKos>> call, Throwable t) {
                Log.e("VMData", t.getMessage());
            }
        });
        return listAnakKos;
    }

    public MutableLiveData<AnakKos> getAnakKosById(String id) {
        MutableLiveData<AnakKos> anakKos = new MutableLiveData<>();
        anakKosApi.getAnakKosById(id).enqueue(new Callback<List<AnakKos>>() {
            @Override
            public void onResponse(Call<List<AnakKos>> call, Response<List<AnakKos>> response) {
                AnakKos res = response.body().get(0);
                Log.d("detailAnakKos", res.getNama());
                anakKos.setValue(res);
            }

            @Override
            public void onFailure(Call<List<AnakKos>> call, Throwable t) {

            }
        });

        return anakKos;
    }
}
