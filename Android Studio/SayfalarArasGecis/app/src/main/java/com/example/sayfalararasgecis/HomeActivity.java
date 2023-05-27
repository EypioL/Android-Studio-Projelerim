package com.example.sayfalararasgecis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView txtKullanici;
    private String gelenKadi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        txtKullanici=(TextView) findViewvvById(R.id.textViewSa);

        Intent gelenIntent= getIntent();
        gelenKadi=gelenIntent.getStringExtra("KullaniciAdi");
        txtKullanici.setText("Hoşgeldiniz: " + gelenKadi);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent= new Intent(HomeActivity.this,MainActivity.class);
        finish();
        startActivity(backIntent);
    }
}