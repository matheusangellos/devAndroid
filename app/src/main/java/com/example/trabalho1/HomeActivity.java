package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.trabalho1.model.Todo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    public void abreTodoActivity(View view) {
        Intent intent = new Intent(this, TodoActivity.class);
        startActivity(intent);
    }

    public void abrePostActivity(View view) {
        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }

    public void abreCommentActivity(View view) {
        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);
    }

    public void abrePhotoActivity(View view) {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }

}