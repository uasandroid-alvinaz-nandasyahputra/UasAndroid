package com.example.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        getSupportActionBar().setTitle("Go-Trash");

        //menggunakan pdfview, dimana file pdfnya diambil dari assets
        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("BankSampahAndroid.pdf")
                .load();

    }
}