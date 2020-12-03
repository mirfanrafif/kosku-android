package com.mirfanrafif.koskuapp.ui.anakkos;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.mirfanrafif.koskuapp.MainActivity;
import com.mirfanrafif.koskuapp.R;
import com.mirfanrafif.koskuapp.models.AnakKos;
import com.mirfanrafif.koskuapp.services.AnakKosApi;
import com.mirfanrafif.koskuapp.services.KoskuClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahAnakKos extends AppCompatActivity {
    private Button simpanButton;
    private EditText namaEdit, asalEdit, nohpEdit;
    String id, method;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_anak_kos);

        Intent intent = getIntent();
        method = intent.getStringExtra("EXTRA_METHOD");

        simpanButton = (Button) findViewById(R.id.simpanButton);
        namaEdit = (EditText) findViewById(R.id.namaInput);
        asalEdit = (EditText) findViewById(R.id.asalInput);
        nohpEdit = (EditText) findViewById(R.id.nohpInput);

        if (method.equals("PUT")) {
            id = intent.getStringExtra("EXTRA_ID");
            namaEdit.setText(intent.getStringExtra("EXTRA_NAMA"));
            asalEdit.setText(intent.getStringExtra("EXTRA_ASAL"));
            nohpEdit.setText(intent.getStringExtra("EXTRA_NOHP"));
        }

        simpanButton.setOnClickListener(v -> saveAnakKos(v));

    }

    public void saveAnakKos(View view) {
        AnakKos anakKos = new AnakKos();

        if (namaEdit.getText().toString().equals("")){
            namaEdit.setError("Nama harus diisi");
            return;
        }else if(asalEdit.getText().toString().equals("")){
            asalEdit.setError("Asal harus diisi");
            return;
        }else if (nohpEdit.getText().toString().equals("")){
            nohpEdit.setError("No. HP Harus diisi");
            return;
        }

        anakKos.setNama(namaEdit.getText().toString());
        anakKos.setAsal(asalEdit.getText().toString());
        anakKos.setNohp(nohpEdit.getText().toString());

        if (method.equals("PUT")){
            new AnakKos().updateDataAnakKos(this, id, anakKos);
        }else{
            new AnakKos().saveDataAnakKos(this, anakKos);
        }

    }
}