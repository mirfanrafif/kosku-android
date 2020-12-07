package com.mirfanrafif.koskuapp.ui.pembayaran;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mirfanrafif.koskuapp.models.AnakKos;
import com.mirfanrafif.koskuapp.services.AnakKosApi;
import com.mirfanrafif.koskuapp.services.KoskuClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class TambahPembayaranViewModel extends ViewModel {
    private MutableLiveData<List<AnakKos>> anakKos = new MutableLiveData<>();
    private MutableLiveData<Integer> bulan = new MutableLiveData<>();
    private MutableLiveData<Integer> tahun = new MutableLiveData<>();

    public TambahPembayaranViewModel() {
        this.bulan.setValue(1);
        this.tahun.setValue(1);

        AnakKosApi anakKosApi = KoskuClient.createService(AnakKosApi.class);
        anakKosApi.getAllAnakKos().enqueue(new Callback<List<AnakKos>>() {
            @Override
            public void onResponse(Call<List<AnakKos>> call, Response<List<AnakKos>> response) {
                anakKos.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AnakKos>> call, Throwable t) {
                Log.e("tambahPembayaran", t.getMessage());
            }
        });
    }

    public MutableLiveData<List<AnakKos>> getAnakKos() {
        return anakKos;
    }

    public void setAnakKos(MutableLiveData<List<AnakKos>> anakKos) {
        this.anakKos = anakKos;
    }

    public MutableLiveData<Integer> getBulan() {
        return bulan;
    }

    public void setBulan(MutableLiveData<Integer> bulan) {
        this.bulan = bulan;
    }

    public MutableLiveData<Integer> getTahun() {
        return tahun;
    }

    public void setTahun(MutableLiveData<Integer> tahun) {
        this.tahun = tahun;
    }
}
