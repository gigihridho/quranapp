package com.example.quranapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapp.R;
import com.example.quranapp.model.Ayat;

import java.util.List;

public class AyatAdapter {
    private Context context;
    private List list;
    private List listIndo;

    public AyatAdapter(Context context, List list, List listIndo) {
        this.context = context;
        this.list = list;
        this.listIndo = listIndo;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_ayat,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Ayat ayat = list.get(position);
        Ayat ayatIndo = listIndo.get(position);
        holder.nomorAyat.setText(ayat.getNomorAyat());
        holder.arabic.setText(ayat.getText());
        holder.tarjim.setText(ayatIndo.getText());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView nomorAyat, arab, tarjim;

        public Holder(View itemView){
            super(itemView);
            nomorAyat = itemView.findViewById(R.id.no_ayat);
            arab = itemView.findViewById(R.id.txtArab);
            tarjim = itemView.findViewById(R.id.txtTerjemahan);
        }
    }
}
