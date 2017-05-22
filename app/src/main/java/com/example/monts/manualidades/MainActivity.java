package com.example.monts.manualidades;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    Button button;
    AlarmManager am;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        button=(Button) findViewById(R.id.alarma);
        am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent();
                in.setAction("com.example.monts.manualidades.action.ALARM_RECEIVER");
                PendingIntent pi=PendingIntent.getBroadcast(
                        getApplicationContext(),
                        0,
                        in,
                        0);
                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+100,pi);

            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.Imagen);
        Glide.with(this).load("https://goo.gl/httnFM").into(imageView);

        firebaseAuth= FirebaseAuth.getInstance();
        final TextInputEditText etEmail= (TextInputEditText) findViewById(R.id.username);
        final TextInputEditText etPassword= (TextInputEditText) findViewById(R.id.password);

        Button btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString().trim();
                String password= etPassword.getText().toString().trim();

                if (email.equals("")){
                    Toast.makeText(MainActivity.this,"Proporcione un nombre de usuario valido",Toast.LENGTH_SHORT).show();
                    return;

                }
                if (password.equals("")){
                    Toast.makeText(MainActivity.this,"Proporcione una contraseña valida",Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    Toast.makeText(MainActivity.this,"Login failed" +task.getException(),Toast.LENGTH_LONG).show();
                                }
                                else {
                                    goContainerActivity();
                                }
                            }
                        });
            }
        });
    }
    public void goCreateAccount(View view){
        Intent intent=new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
    public void goContainerActivity() {
        Intent intent = new Intent(this, cardview.class);
        startActivity(intent);

    }
    public void clickservicio(View view){
        Intent  intent = new Intent(this, servicio.class);
        startActivity(intent);
    }
    @OnClick(R.id.dontHaveAccount)
    public void showToastMessage(){
        Toast.makeText(MainActivity.this,"Registrate aquí",Toast.LENGTH_SHORT).show();
    }
}
