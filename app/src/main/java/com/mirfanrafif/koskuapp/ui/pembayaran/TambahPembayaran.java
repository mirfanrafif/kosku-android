package com.mirfanrafif.koskuapp.ui.pembayaran;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import com.mirfanrafif.koskuapp.MainActivity;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.databinding.ActivityTambahPembayaranBinding;
import com.mirfanrafif.koskuapp.models.AnakKos;
import com.mirfanrafif.koskuapp.models.Pembayaran;
import com.mirfanrafif.koskuapp.services.AnakKosApi;
import com.mirfanrafif.koskuapp.services.KoskuClient;
import com.mirfanrafif.koskuapp.services.PembayaranApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TambahPembayaran extends AppCompatActivity {
    ActivityTambahPembayaranBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView
                (this, R.layout.activity_tambah_pembayaran);

        TambahPembayaranViewModel viewModel = new TambahPembayaranViewModel();
        binding.setViewModel(viewModel);

        binding.getViewModel().getAnakKos().observe(this, new Observer<List<AnakKos>>() {
            @Override
            public void onChanged(List<AnakKos> anakKos) {
                ArrayList<String> listNama = new ArrayList<>();
                for (AnakKos item: binding.getViewModel().getAnakKos().getValue()) {
                    listNama.add(item.getNama() + " - " + item.getId());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter(
                        getApplicationContext(),
                        R.layout.support_simple_spinner_dropdown_item,
                        listNama
                );
                binding.namaAnakKosSpinner.setAdapter(adapter);
            }
        });

        binding.simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveData() {
        Pembayaran pembayaran = new Pembayaran();
        String id = binding.namaAnakKosSpinner.getSelectedItem().toString().split(" - ")[1];
//        Log.d("error", id);
        new AnakKos().getAnakKosById(id).observe(this, new Observer<AnakKos>() {
            @Override
            public void onChanged(AnakKos anakKos) {
                pembayaran.setIdanakkos(anakKos);
                pembayaran.setBulan(Integer.parseInt(binding.bulanInput.getText().toString()));
                pembayaran.setTahun(Integer.parseInt(binding.tahunInput.getText().toString()));

                pembayaran.saveAnakKos();
            }
        });

    }
}