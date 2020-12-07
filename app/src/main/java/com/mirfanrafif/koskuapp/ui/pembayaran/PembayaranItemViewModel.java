package com.mirfanrafif.koskuapp.ui.pembayaran;

import androidx.lifecycle.MutableLiveData;
import com.mirfanrafif.koskuapp.models.Pembayaran;

public class PembayaranItemViewModel {
    private MutableLiveData<String> namaAnakKos;
    private MutableLiveData<String> bulan;
    private MutableLiveData<String> tahun;
    private MutableLiveData<String> id;


    public PembayaranItemViewModel(Pembayaran pembayaran) {
        this.namaAnakKos = new MutableLiveData<>();
        this.bulan = new MutableLiveData<>();
        this.tahun = new MutableLiveData<>();
        this.id = new MutableLiveData<>();

        this.namaAnakKos.setValue(pembayaran.getAnakKos().getNama());
        this.bulan.setValue(pembayaran.getBulan().toString());
        this.tahun.setValue(pembayaran.getTahun().toString());
        this.id.setValue(pembayaran.getId());
    }

    public MutableLiveData<String> getNamaAnakKos() {
        return namaAnakKos;
    }

    public void setNamaAnakKos(MutableLiveData<String> namaAnakKos) {
        this.namaAnakKos = namaAnakKos;
    }

    public MutableLiveData<String> getBulan() {
        return bulan;
    }

    public void setBulan(MutableLiveData<String> bulan) {
        this.bulan = bulan;
    }

    public MutableLiveData<String> getTahun() {
        return tahun;
    }

    public void setTahun(MutableLiveData<String> tahun) {
        this.tahun = tahun;
    }

    public MutableLiveData<String> getId() {
        return id;
    }

    public void setId(MutableLiveData<String> id) {
        this.id = id;
    }
}
