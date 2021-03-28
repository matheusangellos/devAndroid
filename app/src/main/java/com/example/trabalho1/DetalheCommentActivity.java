package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.trabalho1.model.Comment;
import com.example.trabalho1.model.Todo;

public class DetalheCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_comment);
        Intent intent = getIntent();
        Comment todo = intent.getParcelableExtra("objComment");
        TextView tv = findViewById(R.id.tvPostId);
        tv.setText("Post ID: "+todo.getPostId()+"");
        tv = findViewById(R.id.tvId);
        tv.setText("ID: "+todo.getId()+"");
        tv = findViewById(R.id.tvName);
        tv.setText("Name: "+todo.getName()+"");
        tv = findViewById(R.id.tvEmail);
        tv.setText("Email: "+todo.getEmail()+"");
        tv = findViewById(R.id.tvBody);
        tv.setText("Body: "+todo.getBody()+"");
    }
}