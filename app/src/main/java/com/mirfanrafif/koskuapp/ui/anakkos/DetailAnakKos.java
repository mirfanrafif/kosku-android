package com.mirfanrafif.koskuapp.ui.anakkos;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.databinding.ActivityDetailAnakKosBinding;
import com.mirfanrafif.koskuapp.models.AnakKos;
import com.mirfanrafif.koskuapp.services.AnakKosApi;
import com.mirfanrafif.koskuapp.services.KoskuClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class DetailAnakKos extends AppCompatActivity {

    Intent intent;
    ActivityDetailAnakKosBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_anak_kos);

        intent = getIntent();
        String id = intent.getStringExtra("EXTRA_ID");
        Log.d("id", id);
        getAnakKosById(id);
    }

    private void getAnakKosById(String id) {
        AnakKosApi anakKosApi = KoskuClient.createService(AnakKosApi.class);

        anakKosApi.getAnakKosById(id).enqueue(new Callback<List<AnakKos>>() {
            @Override
            public void onResponse(Call<List<AnakKos>> call, Response<List<AnakKos>> response) {
                AnakKos res = response.body().get(0);
                Log.d("detailAnakKos", res.getNama());
                AnakKosViewModel viewModel = new AnakKosViewModel(res);
                binding.setViewModel(viewModel);
            }

            @Override
            public void onFailure(Call<List<AnakKos>> call, Throwable t) {

            }
        });
    }


}