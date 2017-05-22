package com.example.monts.manualidades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class cardview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
    }

    public void cardview1(View view) {
        Intent intent = new Intent(this, ventana1.class);
        startActivity(intent);
    }

    public void cardview2(View view) {
        Intent intent = new Intent(this, ventana2.class);
        startActivity(intent);
    }

    public void cardview3(View view) {
        Intent intent = new Intent(this, ventana3.class);
        startActivity(intent);
    }


}



