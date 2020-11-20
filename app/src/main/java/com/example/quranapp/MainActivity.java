package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.quranapp.adapter.SuratAdapter;
import com.example.quranapp.api.ApiClient;
import com.example.quranapp.api.ApiInterface;
import com.example.quranapp.model.Cek;
import com.example.quranapp.model.Data;
import com.example.quranapp.model.Surat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String arab = "quran-uthmani";
    private static final String indo = "id.indonesian";

    private List<Surat> suratArab = new ArrayList<>();
    private List<Surat> suratIndo = new ArrayList<>();

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Mohon Tunggu ...");
        dialog.setCancelable(false);
        dialog.setMessage("Sedang mengambil data");

        RecyclerView recyclerViewSurat = findViewById(R.id.list_surat);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewSurat.setHasFixedSize(true);
        recyclerViewSurat.setLayoutManager(layoutManager);

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        retrofit2.Call<Cek> call = apiInterface.getCek(arab);
        retrofit2.Call<Cek> callIndo = apiInterface.getCek(indo);

        getDataListArab(recyclerViewSurat, call);
        getDataTarjim(callIndo);
    }

    private void getDataTarjim(Call<Cek> callIndo) {
        callIndo.enqueue(new Callback<Cek>() {
            @Override
            public void onResponse(Call<Cek> call, Response<Cek> response) {
                Data data = response.body().getData();
                suratIndo = data.getSurahs();

            }

            @Override
            public void onFailure(Call<Cek> call, Throwable t) {
                Toast.makeText(MainActivity.this,"gagal",Toast.LENGTH_SHORT).show();
                Log.d("error",t.getMessage());
            }
        });
    }


    private void getDataListArab(final RecyclerView recyclerViewSurat, retrofit2.Call<Cek> call) {
        dialog.show();
        call.enqueue(new Callback<Cek>() {
            @Override
            public void onResponse(retrofit2.Call<Cek> call, Response<Cek> response) {
                Data data = response.body().getData();
                suratArab = data.getSurahs();

                SuratAdapter suratAdapter = new SuratAdapter(MainActivity.this,suratArab,suratIndo);
                recyclerViewSurat.setAdapter(suratAdapter);
                dialog.dismiss();
                }

            @Override
            public void onFailure(retrofit2.Call<Cek> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"gagal",Toast.LENGTH_SHORT).show();
                Log.d("error",t.getMessage());
            }
        });
    }

}
