package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView tv = (TextView) findViewById(R.id.txtHome);
        Intent it = getIntent();
        String txt = it.getStringExtra("nome");
        tv.setText("Bem-vindo(a) "+txt);
        Toast.makeText(this, "Olá "+txt,Toast.LENGTH_LONG).show();
    }

    public void voltaSplashActivity(View view) {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }
}