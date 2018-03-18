package com.example.vivekpatel.homepage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by VIVEK PATEL on 2/27/2018.
 */

public class MusicList extends RecyclerView.Adapter<MusicList.MyViewHolder> {

    private Context mContext;
    private List<SongInfo> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView songtitle,songdes,time;
        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            songdes = (TextView) view.findViewById(R.id.song_des);
            songtitle = (TextView) view.findViewById(R.id.songtitle);
            time = (TextView) view.findViewById(R.id.time);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                       Intent i = new Intent(mContext,SongPlay.class);
                       mContext.startActivity(i);
                }
            });
        }
    }


    public MusicList(Context mContext, List<SongInfo> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        SongInfo album = albumList.get(position);
        holder.thumbnail.setBackgroundResource(R.drawable.quora);
        holder.songtitle.setText(album.getSession());
     //   holder.like.setBackgroundResource(android.R);
        holder.time.setText(album.getTime());
        holder.songdes.setText(album.getSongName());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}