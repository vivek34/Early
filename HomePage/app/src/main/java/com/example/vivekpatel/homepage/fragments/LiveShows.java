package com.example.vivekpatel.homepage.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivekpatel.homepage.Adapters.MainScreenSongAdapter;
import com.example.vivekpatel.homepage.R;
import com.example.vivekpatel.homepage.model.SongInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VIVEK PATEL on 3/18/2018.
 */

public class LiveShows extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private MainScreenSongAdapter adapter;
    private List<SongInfo> songList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.live_shows, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        songList = new ArrayList<>();
        adapter = new MainScreenSongAdapter(getActivity(), songList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareSongs();
    }

    private void prepareSongs() {
        SongInfo a = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a);
        SongInfo a1 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a1);
        SongInfo a2 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a2);
        SongInfo a3 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a3);
        SongInfo a4 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a4);
        SongInfo a5 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a5);
        SongInfo a6 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a6);
        SongInfo a7 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a7);
        SongInfo a8 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a8);
        SongInfo a9 = new SongInfo("Quora Qaagaz", "Session1-Session2", "22.4k", "2:10 min");
        songList.add(a9);
        adapter.notifyDataSetChanged();
    }
}