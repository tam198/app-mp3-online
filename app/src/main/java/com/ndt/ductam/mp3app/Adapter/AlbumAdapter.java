package com.ndt.ductam.mp3app.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ndt.ductam.mp3app.Activity.DanhsachbaihatActivity;
import com.ndt.ductam.mp3app.Model.Album;
import com.ndt.ductam.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Album album = mangalbum.get(position);
        viewHolder.txtcasialbum.setText(album.getTenCaSiAlbum());
        viewHolder.txttenalbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhAlbum()).into(viewHolder.imghinhalbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imghinhalbum;
        TextView txttenalbum, txtcasialbum;
        public ViewHolder(View itemView) {
            super(itemView);
            imghinhalbum = itemView.findViewById(R.id.imageviewalbum);
            txttenalbum = itemView.findViewById(R.id.textviewtenalbum);
            txtcasialbum = itemView.findViewById(R.id.textviewtencasialbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album", mangalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
