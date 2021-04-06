package com.example.trabalho1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.R;
import com.example.trabalho1.model.Comment;
import com.example.trabalho1.model.Todo;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private List<Comment> listaComments;

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public View viewComment;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewComment = itemView;
        }
    }

    public CommentAdapter(List<Comment> comments) { this.listaComments = comments; }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_comment, parent, false);
        return new CommentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {
        Comment obj = this.listaComments.get(position);
        TextView tv = holder.viewComment.findViewById(R.id.tvPostId);
        tv.setText("Post ID: "+obj.getPostId());
        tv = holder.viewComment.findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = holder.viewComment.findViewById(R.id.tvName);
        tv.setText("Name: "+obj.getName()+"");
        tv = holder.viewComment.findViewById(R.id.tvEmail);
        tv.setText("Email: "+obj.getEmail()+"");
        tv = holder.viewComment.findViewById(R.id.tvBody);
        tv.setText("Body: "+obj.getBody()+"");
    }

    @Override
    public int getItemCount() { return this.listaComments.size(); }
}
