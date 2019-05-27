package com.example.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class JenisSampah extends AppCompatActivity {
    private RecyclerView list_item;
    private android.support.v7.widget.LinearLayoutManager LinearLayoutManager;
    private List<ItemObject> itemObjects;
    private AdapterItem adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_sampah);

        getSupportActionBar().setTitle("Go-Trash");
//RecyclerView
        /*casting variable*/
        list_item = (RecyclerView) findViewById(R.id.lst_item);

        /*memasukkan layout ini ke recyclerView*/
        LinearLayoutManager = new LinearLayoutManager(this);
        list_item.setLayoutManager(LinearLayoutManager);

        //isi arraylist
        itemObjects = new ArrayList<>();
        itemObjects.add(new ItemObject("ALUMUNIUM", "Rp.10000-/kg", R.drawable.alumunium));
        itemObjects.add(new ItemObject("BOTOL PLASTIK", "Rp.400-/kg", R.drawable.botolplastik));
        itemObjects.add(new ItemObject("GELAS PLASTIK", "Rp.300-/kg", R.drawable.gelasplastik));
        itemObjects.add(new ItemObject("KARDUS BEKAS", "Rp.1000-/kg", R.drawable.karduss));
        itemObjects.add(new ItemObject("KORAN BEKAS", "Rp.800-/kg", R.drawable.koran));
        itemObjects.add(new ItemObject("PARALON", "Rp.900-/kg", R.drawable.paralon));
        itemObjects.add(new ItemObject("SENG", "Rp.1300-/kg", R.drawable.seng));
        itemObjects.add(new ItemObject("KORAN BEKAS", "Rp.800-/kg", R.drawable.koran));
        itemObjects.add(new ItemObject("PARALON", "Rp.900-/kg", R.drawable.paralon));
        itemObjects.add(new ItemObject("SENG", "Rp.1300-/kg", R.drawable.seng));
        /*membuat adapter*/
        adapter = new AdapterItem(getApplicationContext(), itemObjects);
        /*masukkan ke recyclerview*/
        list_item.setAdapter(adapter);

    }

    //pemanggilan intent untuk kehalaman selanjutnya
    public void next(View view) {
        Intent j = new Intent(JenisSampah.this, BiodataActivity.class);
        startActivity(j);
    }
}
