package com.example.sayfalararasgecis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText kullaniciadi, sifre;
    private TextView txtSonuc;
    private String kAdi, kSifre, dogruKadi = "Mustafa", dogruKsifre= "1234M";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullaniciadi=(EditText) findViewById(R.id.editTxtKullaniciAdi);
        sifre=(EditText) findViewById(R.id.editTxtSifre);
        txtSonuc=(TextView) findViewById(R.id.textViewSonuc);
    }

    public void btnGirisYap(View v){
        kAdi= kullaniciadi.getText().toString();
        kSifre= sifre.getText().toString();

        if (!TextUtils.isEmpty(kAdi)){
              if(!TextUtils.isEmpty(kSifre)){
                       if(kAdi.equals(dogruKadi)){
                           if(kSifre.equals(dogruKsifre)){
                               Intent intent= new Intent(MainActivity.this,HomeActivity.class);
                               intent.putExtra("kullaniciadi",kAdi);
                               finish();
                               startActivity(intent);
                               //Geçiş Yap
                           }else txtSonuc.setText("Şifrenizi Yanlış Girdiniz.");
                       }else
                           txtSonuc.setText("Kullanıcı Adınızı Yanlış Giriniz");
              }else
                  txtSonuc.setText("Şifrenizi Boş Giremezsiniz.");
        }else
            txtSonuc.setText("Kullanıcı Adınızı Boş Giremezsiniz");
    }
}