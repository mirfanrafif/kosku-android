package com.mirfanrafif.koskuapp.ui.anakkos;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mirfanrafif.koskuapp.models.AnakKos;
public class AnakKosItemViewModel extends ViewModel {
    private MutableLiveData<String> nama = new MutableLiveData<>();
    public MutableLiveData<String> asal = new MutableLiveData<>();
    public MutableLiveData<String> nohp = new MutableLiveData<>();
    public MutableLiveData<String> id = new MutableLiveData<>();

    public AnakKosItemViewModel(AnakKos anakKos) {
        nama.setValue(anakKos.getNama());
        asal.setValue(anakKos.getAsal());
        nohp.setValue(anakKos.getNohp());
        id.setValue(anakKos.getId());
    }

    public String getNama() {
        return nama.getValue();
    }

    public void setNama(String nama) {
        this.nama.setValue(nama);
    }

    public String getAsal() {
        return asal.getValue();
    }

    public void setAsal(String asal) {
        this.asal.setValue(asal);
    }

    public String getNohp() {
        return this.nohp.getValue();
    }

    public void setNohp(String nohp) {
        this.nohp.setValue(nohp);
    }

    public String getId() {
        return this.id.getValue();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }
}
