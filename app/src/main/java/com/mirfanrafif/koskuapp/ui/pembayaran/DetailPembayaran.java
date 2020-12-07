package com.mirfanrafif.koskuapp.ui.pembayaran;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.databinding.ActivityDetailPembayaranBinding;
import com.mirfanrafif.koskuapp.models.Pembayaran;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class DetailPembayaran extends AppCompatActivity {

    TextView namaText, bulanText, tahunText;
    ActivityDetailPembayaranBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_pembayaran);
        Intent intent = getIntent();
        String id = intent.getStringExtra("EXTRA_ID");
        Log.d("detail", "id : " + id);

        namaText = findViewById(R.id.namaText);
        bulanText = findViewById(R.id.bulantext);
        tahunText = findViewById(R.id.tahunText);

        getData(id);
    }

    private void getData(String id) {
        new Pembayaran().getById(id).observe(this, new Observer<Pembayaran>() {
            @Override
            public void onChanged(Pembayaran pembayaran) {
                PembayaranItemViewModel viewModel = new PembayaranItemViewModel(pembayaran);
                binding.setViewModel(viewModel);
            }
        });

    }
}