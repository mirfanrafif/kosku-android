package com.mirfanrafif.koskuapp.ui.anakkos;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.mirfanrafif.koskuapp.MainActivity;
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

        binding.hapusButton.setOnClickListener(v -> {
            hapusData(id);
        });

        binding.ubahButton.setOnClickListener(v -> {
            ubahData();
        });
    }

    public void hapusData(String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Hapus Data")
                .setMessage("Apakah anda ingin menghapus data ini?")
                .setPositiveButton("Ya", (dialog, which) -> {
                    new AnakKos().deleteAnakKosById(id);
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                })
                .setNegativeButton("Tidak", (dialog, which) -> {
                    dialog.cancel();
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void ubahData() {
        Intent intent = new Intent(this, TambahAnakKos.class);
        intent.putExtra("EXTRA_METHOD", "PUT");
        intent.putExtra("EXTRA_ID", binding.getViewModel().getId());
        intent.putExtra("EXTRA_NAMA", binding.getViewModel().getNama());
        intent.putExtra("EXTRA_ASAL", binding.getViewModel().getAsal());
        intent.putExtra("EXTRA_NOHP", binding.getViewModel().getNohp());
        startActivity(intent);
    }

}