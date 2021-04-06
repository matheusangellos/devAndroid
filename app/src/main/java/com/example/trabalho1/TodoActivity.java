package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.trabalho1.adapter.TodoAdapter;
import com.example.trabalho1.model.Todo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity  implements Response.Listener<JSONArray>, Response.ErrorListener{

        List<Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        TextView tv = (TextView) findViewById(R.id.txtHome);
        Intent it = getIntent();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/todos";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);

        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Todo obj = new Todo(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed"));
                todos.add(obj);
            }
            RecyclerView rv = findViewById(R.id.rvTodos);
            //RecyclerView rv2 = findViewById(R.id.rvTodos2);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            //LinearLayoutManager llhm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            //LinearLayoutManager llhm2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            //GridLayoutManager glm = new GridLayoutManager(this, 3);
            //StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            rv.setLayoutManager(llm);
            //rv2.setLayoutManager(llhm2);
            TodoAdapter todoAdapter = new TodoAdapter(todos);
            //TodoAdapter todoAdapter2 = new TodoAdapter(todos.subList(1, 4));
            rv.setAdapter(todoAdapter);
            //rv2.setAdapter(todoAdapter2);
            /*
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for (Todo obj1 : todos) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        Todo todo = (Todo) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalheTodoActivity.class);
                        intent.putExtra("objTodo", todo);
                        startActivity(intent);
                    }
                });
                ll.addView(bt);
            } */
        } catch (JSONException e) {
            Log.e("erro", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(), "deu erro: "+msg, Toast.LENGTH_LONG).show();
    }
}