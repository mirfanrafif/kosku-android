package com.mirfanrafif.koskuapp.ui.pembayaran;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.mirfanrafif.koskuapp.models.Pembayaran;

import java.util.List;

public class PembayaranViewModel extends ViewModel {

    private MutableLiveData<List<Pembayaran>> pembayaranList;

    public PembayaranViewModel() {
        pembayaranList = new Pembayaran().getAllPembayaran();
    }

    public MutableLiveData<List<Pembayaran>> getPembayaranList() {
        return pembayaranList;
    }
}