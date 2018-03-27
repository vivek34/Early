package com.example.vivekpatel.homepage.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vivekpatel.homepage.R;
import com.example.vivekpatel.homepage.model.SongInfo;

import java.util.List;

/**
 * Created by VIVEK PATEL on 2/27/2018.
 */

public class MainScreenSongAdapter extends RecyclerView.Adapter<MainScreenSongAdapter.MyViewHolder> {

    private Context mContext;
    private List<SongInfo> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail,like;
        TextView songtitle,songdes,time,likes;
        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            songdes = (TextView) view.findViewById(R.id.song_des);
            songtitle = (TextView) view.findViewById(R.id.songtitle);
            time = (TextView) view.findViewById(R.id.time);
        }
    }

    public MainScreenSongAdapter(Context mContext, List<SongInfo> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        SongInfo album = albumList.get(position);
        //holder.thumbnail.setBackgroundResource(album.getSong_image());
        holder.songtitle.setText(album.getSession());
        holder.time.setText(album.getTime());
        holder.songdes.setText(album.getSongName());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}