package com.example.loginactivity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Holder extends RecyclerView.ViewHolder {
    //variable
    public TextView txt_judul, txt_harga;
    public ImageView img_icon;

    //mendeklarasikan dari class item object
    public Holder(View itemView) {
        super(itemView);

        txt_judul = (TextView) itemView.findViewById(R.id.txt_judul);
        txt_harga = (TextView) itemView.findViewById(R.id.txt_harga);
        img_icon = (ImageView) itemView.findViewById(R.id.img_icon);
    }
}
