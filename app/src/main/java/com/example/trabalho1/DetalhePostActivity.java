package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.trabalho1.model.Post;
import com.example.trabalho1.model.Todo;

public class DetalhePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_post);
        Intent intent = getIntent();
        Post todo = intent.getParcelableExtra("objPost");
        TextView tv = findViewById(R.id.tvUserId);
        tv.setText("User ID: "+todo.getUserId()+"");
        tv = findViewById(R.id.tvId);
        tv.setText("ID: "+todo.getId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText("Title: "+todo.getTitle());
        tv = findViewById(R.id.tvBody);
        tv.setText("Body: "+todo.getBody());
    }
}