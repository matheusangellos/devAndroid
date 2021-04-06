package com.example.trabalho1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.R;
import com.example.trabalho1.model.Comment;
import com.example.trabalho1.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> listaPosts;

    public class PostViewHolder extends RecyclerView.ViewHolder {
        public View viewPost;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPost = itemView;
        }
    }

    public PostAdapter(List<Post> posts) { this.listaPosts = posts; }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_post, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        Post obj = this.listaPosts.get(position);
        TextView tv = holder.viewPost.findViewById(R.id.tvUserId);
        tv.setText("User ID: "+obj.getUserId()+"");
        tv = holder.viewPost.findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = holder.viewPost.findViewById(R.id.tvTitle);
        tv.setText("Title: "+obj.getTitle());
        tv = holder.viewPost.findViewById(R.id.tvBody);
        tv.setText("Body: "+obj.getBody());
    }

    @Override
    public int getItemCount() { return this.listaPosts.size(); }
}
