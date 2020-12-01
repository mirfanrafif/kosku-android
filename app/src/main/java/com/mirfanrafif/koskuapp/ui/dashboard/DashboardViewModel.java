package com.mirfanrafif.koskuapp.ui.dashboard;

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
import retrofit2.Retrofit;

import java.util.List;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> title;
    private AnakKosApi anakKosApi;
    private MutableLiveData<List<AnakKos>> listAnakKos;

    public DashboardViewModel() {
        title = new MutableLiveData<>();
        title.setValue("Data Anak Kos");
        anakKosApi = KoskuClient.createService(AnakKosApi.class);
    }

    public LiveData<String> getTitle() {
        return title;
    }

    public MutableLiveData<List<AnakKos>> getListAnakKos() {
        if (listAnakKos == null) {
            listAnakKos = new MutableLiveData<>();
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
        }
        return listAnakKos;
    }

    @BindingAdapter("android:visibility")
    public void setVisibility(View view,Boolean value) {
        view.setVisibility(value ? View.VISIBLE : View.INVISIBLE);
    }
}