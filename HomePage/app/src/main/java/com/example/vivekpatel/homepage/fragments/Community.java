package com.example.vivekpatel.homepage.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.example.vivekpatel.homepage.Adapters.CommuntiyAdapter;

//import com.example.vivekpatel.homepage;
import com.example.vivekpatel.homepage.R;
import com.example.vivekpatel.homepage.model.CommunityInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VIVEK PATEL on 3/18/2018.
 */

public class Community extends Fragment {


    private RecyclerView recyclerView;
   // private CommuntiyAdapter adapter;
    private List<CommunityInfo> detailList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.community, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        detailList = new ArrayList<>();
     //   adapter = new CommuntiyAdapter(getActivity(),detailList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
      //  recyclerView.setAdapter(adapter);
        prepareSongs();
    }

    private void prepareSongs() {
        CommunityInfo a1 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a1);
        CommunityInfo a2 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a2);
        CommunityInfo a3 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a3);
        CommunityInfo a4 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a4);
        CommunityInfo a5 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a5);
        CommunityInfo a6 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a6);
        CommunityInfo a7 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a7);
        CommunityInfo a8 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a8);
        CommunityInfo a9 = new CommunityInfo("Some Community Guy 0", "Member at STILL A STUDENT DUDE!!!", "256", "256","256");
        detailList.add(a9);
       // adapter.notifyDataSetChanged();
    }
}

