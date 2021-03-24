package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void abreHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);

        EditText editNome = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText editSenha = (EditText)findViewById(R.id.editTextTextPassword);
        intent.putExtra("nome", editNome.getText().toString());
        if(editNome.getText().toString().equals(editSenha.getText().toString())) {
            startActivity(intent);
        }else {
            Toast.makeText(this, "Usuario e senha não conferem! ",Toast.LENGTH_LONG).show();
        }
    }
}