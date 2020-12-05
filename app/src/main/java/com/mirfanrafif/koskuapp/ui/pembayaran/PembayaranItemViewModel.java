package com.mirfanrafif.koskuapp.ui.pembayaran;

import androidx.lifecycle.MutableLiveData;
import com.mirfanrafif.koskuapp.models.Pembayaran;

public class PembayaranItemViewModel {
    private MutableLiveData<String> namaAnakKos;
    private MutableLiveData<String> bulan;
    private MutableLiveData<String> tahun;


    public PembayaranItemViewModel(Pembayaran pembayaran) {
        this.namaAnakKos = new MutableLiveData<>();
        this.bulan = new MutableLiveData<>();
        this.tahun = new MutableLiveData<>();

        this.namaAnakKos.setValue(pembayaran.getAnakKos().getNama());
        this.bulan.setValue(pembayaran.getBulan().toString());
        this.tahun.setValue(pembayaran.getTahun().toString());
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
}
