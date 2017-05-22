package com.example.monts.manualidades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class servicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio);
    }
    public void startService(View view){
        startService(new Intent(getBaseContext(),MyService.class));
    }

    public void destroyService(View view){
        stopService(new Intent(getBaseContext(),MyService.class));
    }
}
