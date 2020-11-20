package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.quranapp.adapter.AyatAdapter;
import com.example.quranapp.model.Ayat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SuratActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat);

        Toolbar aToolbarSurat = findViewById(R.id.aToolbarSurat);
        setSupportActionBar(aToolbarSurat);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        String json = getIntent().getStringExtra("jsonlist");
        String jsonIndo = getIntent().getStringExtra("jsonlistIndo");
        String jsonTitle = getIntent().getStringExtra("jsonTitle");
        Type type = new TypeToken<Ayat>(){}.getType();

        TextView txtTitleSurat = findViewById(R.id.titleSurat);
        txtTitleSurat.setText(jsonTitle);
        txtTitleSurat.findViewById(R.id.titleSurat);
        txtTitleSurat.setText(jsonTitle);

        Gson gson = new Gson();
        List<Ayat> ayatList = gson.fromJson(json,type);
        List<Ayat> ayatListIndo = gson.fromJson(jsonIndo,type);

        RecyclerView recyclerViewAyat = findViewById(R.id.ayat_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        AyatAdapter ayatAdapter = new AyatAdapter(this,ayatList,ayatListIndo);
        recyclerViewAyat.setLayoutManager(linearLayoutManager);
        recyclerViewAyat.setHasFixedSize(true);
        recyclerViewAyat.setAdapter(ayatAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}