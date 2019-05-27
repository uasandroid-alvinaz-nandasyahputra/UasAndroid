package com.example.loginactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class BiodataActivity extends AppCompatActivity {

    String[] daftar;
    //mendeklarasikan list viewnya
    ListView ListView01;
    // (penting)untuk pengaksesan databasenya
    Menu menu;
    // karena kita akan menggunakan Query jadi harus ada cursor
    protected Cursor cursor;
    // karena kita akan mengambil proses dari dataHelper dengan variable dbcenter
    DataHelper dbcenter;

    // nanti akan diakses di class buatbiodata, lihatbiodata, updatebiodata
    public static BiodataActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        //untuk title judul penggantian nama
        getSupportActionBar().setTitle("Go-Trash");

        //pemanggilan button dari BiodataActivity -> Buat Biodata
        Button btn=(Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intentt = new Intent(BiodataActivity.this, BuatBiodata.class);
                startActivity(intentt);
            }
        });

        // deklarasi main activity
        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }
    // method untuk pengaksesan dan penampilan data
    public void RefreshList(){
        // dbcenter(telah kita buat) mengambil data dari dataHelper dimasukkan ke db dengan typedata SQLiteDb
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        // cursor(telah kita buat) untuk Query (Pemanggilan data/perintah data)
        cursor = db.rawQuery("SELECT * FROM biodata",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView)findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(BiodataActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                //apabila memilih case 1 maka dia akan memanggil layout lihat biodata (move layout)
                                Intent i = new Intent(getApplicationContext(), LihatBiodata.class);
                                i.putExtra("nama", selection);
                                startActivity(i);
                                break;
                            case 1 :
                                //apabila memilih case 2 maka dia akan memanggil layout UpdateBiodata (move layout)
                                Intent in = new Intent(getApplicationContext(), UpdateBiodata.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                //apabila memilih case 3 maka dia akan memanggil layout delete biodata (move layout)
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                // syntax dari sqllite untuk menghapus
                                db.execSQL("delete from biodata where nama = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}
