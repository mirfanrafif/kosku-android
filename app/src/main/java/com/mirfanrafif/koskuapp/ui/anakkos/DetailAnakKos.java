package com.mirfanrafif.koskuapp.ui.anakkos;

import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.databinding.ActivityDetailAnakKosBinding;
import com.mirfanrafif.koskuapp.models.AnakKos;

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

        new AnakKos().getAnakKosById(id).observe(this, anakKos -> {
            binding.setViewModel(new AnakKosItemViewModel(anakKos));
        });
    }




}