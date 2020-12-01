package com.mirfanrafif.koskuapp.ui.AnakKos;

import androidx.lifecycle.ViewModel;
import com.mirfanrafif.koskuapp.models.AnakKos;

public class AnakKosViewModel extends ViewModel {
    private String nama;
    public String asal;
    public String nohp;

    public AnakKosViewModel(AnakKos anakKos) {
        this.nama = anakKos.getNama();
        this.asal = anakKos.getAsal();
        this.nohp = anakKos.getNohp();
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
}
