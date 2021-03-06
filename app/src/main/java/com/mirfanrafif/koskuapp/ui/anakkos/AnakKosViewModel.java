package com.mirfanrafif.koskuapp.ui.anakkos;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mirfanrafif.koskuapp.models.AnakKos;
import com.mirfanrafif.koskuapp.services.AnakKosApi;
import com.mirfanrafif.koskuapp.services.KoskuClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AnakKosViewModel extends ViewModel {

    private MutableLiveData<String> title;
    private MutableLiveData<List<AnakKos>> listAnakKos;

    public AnakKosViewModel() {
        title = new MutableLiveData<>();
        title.setValue("Data Anak Kos");
        listAnakKos =  new AnakKos().getListAnakKos();
    }

    public LiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<List<AnakKos>> getListAnakKos() {
        return listAnakKos;
    }

    @BindingAdapter("android:visibility")
    public void setVisibility(View view,Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.INVISIBLE);
    }
}