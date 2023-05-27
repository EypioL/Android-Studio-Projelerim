package com.nihalisik.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    String GerıDon;
    Button button_geridon;
    int sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView_sayac);
        button_geridon=findViewById(R.id.geridon);
        button_geridon.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        String sayac = intent.getStringExtra("editSayi");
        textView.setText(sayac);
        sure=(Integer.parseInt(textView.getText().toString()))*1000;
        new CountDownTimer(sure, 1000) {
            @Override
            public void onTick(long l) {
                textView.setText(""+l/1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Tamamlandı!",Toast.LENGTH_LONG).show();
                button_geridon.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void GerıDon(View view){
        GerıDon=textView.getText().toString();
        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        intent.putExtra("GerıDon",GerıDon);
        startActivity(intent);
    }
}
