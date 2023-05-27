package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBirinciSayi, editTextİkinciSayi;
    private TextView txtSonuc;
    private String birinciSayi, ikinciSayi;
    private int s1, s2, sonuc;
    private Hesapla hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextBirinciSayi = (EditText) findViewById(R.id.editTxtBirinciSayi);
        editTextİkinciSayi = (EditText) findViewById(R.id.editTxtİkinciSayi);
        txtSonuc = (TextView) findViewById(R.id.TxtViewSonuc);

    }

    public void btnHesapla(View v) {
        birinciSayi = editTextBirinciSayi.getText().toString();
        ikinciSayi = editTextİkinciSayi.getText().toString();

        if (!TextUtils.isEmpty(birinciSayi) && !TextUtils.isEmpty(ikinciSayi)) {
            s1 = Integer.valueOf(birinciSayi);
            s2 = Integer.valueOf(ikinciSayi);
            hesapla = new Hesapla(s1, s2);

            switch (v.getId()) {
                case R.id.btnTopla:
                    sonuc = hesapla.toplam();
                    break;

                case R.id.btnFark:
                    sonuc = hesapla.fark();
                    break;

                case R.id.btnBolme:
                    sonuc = hesapla.bol();
                    break;

                case R.id.btnCarp:
                    sonuc = hesapla.carpim();
                    break;
            }

            txtSonuc.setText("Sonuç:" + sonuc);
        } else
            txtSonuc.setText("Girilen Değerler Boş Olamaz.");
    }
}