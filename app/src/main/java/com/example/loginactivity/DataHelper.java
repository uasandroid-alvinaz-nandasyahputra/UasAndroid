package com.example.loginactivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//sqlliteopenhelper UNTUK PROSES DATABASE
public class DataHelper extends SQLiteOpenHelper {
    //DEKLARASI UNTUK MEMBUAT NAMA DATABASE
    private static final String DATABASE_NAME = "   biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    //Konstuktor harus sama dengan nama class
    public DataHelper(Context context) {
        //panggil database_name dan database_vertsion
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    // nama parameter (db)
    // biar dataHelper tidak error
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // deklarasi nama untuk menyimpan table dan atributnya
        // sytntax membuat table (create table....)
        String sql = "create table biodata(no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }
}
