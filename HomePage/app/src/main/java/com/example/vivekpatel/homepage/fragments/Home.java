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

import com.example.vivekpatel.homepage.Activities.MainScreen;
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


    ArrayList<SectionDataModel> SampleData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SampleData = new ArrayList<>();

        Shows_Data();

        RecyclerView my_recycler_view = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        TrendingAdapter adapter = new TrendingAdapter((MainScreen) getActivity(),SampleData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
    }


    public void Shows_Data() {
        for (int i = 1; i <= 3; i++) {
            SectionDataModel dm = new SectionDataModel();
            if (i == 1) {
                dm.setHeaderTitle("LATEST SHOWS");
            }
            if (i == 2) {
                dm.setHeaderTitle("POPULAR SHOWS");
            }
            if (i == 3) {
                dm.setHeaderTitle("LIVE SHOWS");
            }
            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }
            dm.setAllItemsInSection(singleItem);
            SampleData.add(dm);

        }
    }
}
