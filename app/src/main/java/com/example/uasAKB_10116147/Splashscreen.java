package com.example.uasAKB_10116147;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

// Tanggal  Pengerjaan  : 7-11 Agustus 2020
// NIM	            	: 10116147
// Nama                 : Garry Prang
// Kelas	            : IF-3

public class Splashscreen extends AppCompatActivity {
    private int waktu=9000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashsreen=new Intent(Splashscreen.this, MainActivity.class);
                startActivity(splashsreen);
                finish();
            }
        },waktu);
    }
}