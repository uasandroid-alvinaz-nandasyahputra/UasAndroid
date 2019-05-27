package com.example.loginactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

//penghubung
public class AdapterItem extends RecyclerView.Adapter<Holder> {

    Context context;
    //array
    List<ItemObject> itemObjects;


    //Konstruktor untuk mengisi Adapter dengan untaian data yang hendak ditaruh.
    public AdapterItem(Context context, List<ItemObject> itemObjects) {
        this.context = context;
        this.itemObjects = itemObjects;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_object, null);
        Holder holderItem = new Holder(view);
        return holderItem;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.txt_judul.setText(itemObjects.get(position).strJudul);
        holder.txt_harga.setText(itemObjects.get(position).strHarga);
        Glide.with(context)
                .load(itemObjects.get(position).gmbr)
                .into(holder.img_icon);
    }

    @Override
    public int getItemCount() {
        return itemObjects.size();
//mengembalikan jumlah itemobject
    }
}