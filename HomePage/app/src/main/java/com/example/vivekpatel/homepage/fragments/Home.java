package com.example.vivekpatel.homepage.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivekpatel.homepage.Adapters.MainScreenSongAdapter;
import com.example.vivekpatel.homepage.Adapters.TrendingAdapter;
import com.example.vivekpatel.homepage.R;
import com.example.vivekpatel.homepage.model.SectionDataModel;
import com.example.vivekpatel.homepage.model.SingleItemModel;
import com.example.vivekpatel.homepage.model.SongInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VIVEK PATEL on 3/18/2018.
 */
public class Home extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
