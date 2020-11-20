package com.example.quranapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapp.R;
import com.example.quranapp.SuratActivity;
import com.example.quranapp.model.Surat;
import com.google.gson.Gson;

import java.util.List;

public class SuratAdapter extends RecyclerView.Adapter<SuratAdapter.Holder> {
    private Context context;
    private List<Surat> list;
    private List<Surat> listIndo;
    private View view;

    public SuratAdapter(Context context, List<Surat> list, List<Surat> listIndo) {
        this.context = context;
        this.list = list;
        this.listIndo = listIndo;
    }

    public SuratAdapter(Context context, List<Surat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SuratAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        view = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);
        return new Holder(view);
    }

    @SuppressLint("SetTextI18n")

    @Override
    public void onBindViewHolder(@NonNull SuratAdapter.Holder holder, int position) {
        final Surat surat = list.get(position);
        final Surat suratIndo = listIndo.get(position);

        holder.numberSurah.setText(surat.getNumber());
        holder.titleSurah.setText(surat.getName());
        holder.typeTitle.setText(surat.getType());
        holder.translationTitle.setText(surat.getTranslateName());
        holder.ayatSize.setText(surat.getAyatList().size()+" ayat");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String json = gson.toJson(surat.getAyatList());
                String jsonIndo = gson.toJson(surat.getAyatList());
                Intent intent = new Intent(context, SuratActivity.class);
                intent.putExtra("jsonlist",json);
                intent.putExtra("jsonlistIndo",jsonIndo);
                intent.putExtra("jsonTitle",surat.getEnglishName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView numberSurah, titleSurah, translationTitle, typeTitle, ayatSize;

        public Holder(@NonNull View itemView) {
            super(itemView);
            numberSurah = itemView.findViewById(R.id.no_surat);
            titleSurah = itemView.findViewById(R.id.titleSurat);
            translationTitle = itemView.findViewById(R.id.txtTerjemahan);
            typeTitle = itemView.findViewById(R.id.txtTypeSurat);
            ayatSize = itemView.findViewById(R.id.ukuran_ayat);
        }
    }
}
