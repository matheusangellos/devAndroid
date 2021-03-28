package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.trabalho1.model.Todo;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objTodo");
        TextView tv = findViewById(R.id.tvUserId);
        tv.setText("User ID: "+todo.getId()+"");
        tv = findViewById(R.id.tvId);
        tv.setText("ID: "+todo.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText("Title: "+todo.getTitle());
        CheckBox cb = findViewById(R.id.cbCompleted);
        cb.setChecked(todo.isCompleted());
    }
}