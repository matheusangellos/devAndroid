package com.example.trabalho1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho1.R;
import com.example.trabalho1.model.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<Photo> listaPhotos;

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        public View viewPhoto;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPhoto = itemView;
        }
    }

    public PhotoAdapter(List<Photo> photos) { this.listaPhotos = photos; }

    @NonNull
    @Override
    public PhotoAdapter.PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalhe_photo, parent, false);
        return new PhotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.PhotoViewHolder holder, int position) {
        Photo obj = this.listaPhotos.get(position);
        TextView tv = holder.viewPhoto.findViewById(R.id.tvUserId);
        tv.setText("Album ID: "+obj.getAlbumId()+"");
        tv = holder.viewPhoto.findViewById(R.id.tvId);
        tv.setText("ID: "+obj.getId()+"");
        tv = holder.viewPhoto.findViewById(R.id.tvTitle);
        tv.setText("Title: "+obj.getTitle()+"");
        tv = holder.viewPhoto.findViewById(R.id.tvBody);
        tv.setText("URL: "+obj.getUrl()+"");
        tv = holder.viewPhoto.findViewById(R.id.tvThumbnailUrl);
        tv.setText("Thumbnail: "+obj.getThumbnailUrl()+"");
    }

    @Override
    public int getItemCount() { return this.listaPhotos.size(); }
}
