package com.nihalisik.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText_sayac;
    String sayi;
    TextView textView;
    int storedSayi;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_sayac = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView_bilgi);
        sharedPreferences = this.getSharedPreferences("com.nihalisik.quiz", Context.MODE_PRIVATE);
        sayi = editText_sayac.getText().toString();
        storedSayi = sharedPreferences.getInt("storedSayi", 0);
        if (storedSayi == 0) {
            editText_sayac.setText("0");
        } else {
            editText_sayac.setText("" + storedSayi);
        }
    }

    public void SayaciBaslat(View view) {
        sayi = editText_sayac.getText().toString();
        if (sayi != null && !sayi.isEmpty()) {
            int sure = Integer.parseInt(sayi);
            editText_sayac.setText("" + sure);
            if (sure < 5 || sure > 30) {
                textView.setText("Yazılan süre sınırlar dahilinde değildir.");
            } else {
                sayi = editText_sayac.getText().toString();
                sharedPreferences.edit().putInt("storedSayi", sure).apply();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("editSayi", sayi);
                startActivity(intent);
            }
        } else {
            textView.setText("Boş Bırakılamaz!");

        }
    }
}