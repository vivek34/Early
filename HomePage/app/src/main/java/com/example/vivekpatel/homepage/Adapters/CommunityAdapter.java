package com.example.vivekpatel.homepage.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vivekpatel.homepage.Activities.MainScreen;
import com.example.vivekpatel.homepage.Activities.SongList;
import com.example.vivekpatel.homepage.R;
import com.example.vivekpatel.homepage.model.CommunityInfo;
import com.example.vivekpatel.homepage.model.SingleItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pR0 on 3/30/2018.
 */

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.SingleItemRowHolder> {

    private List<CommunityInfo> itemsList;
    private Context mContext;

    public CommunityAdapter(MainScreen context, List<CommunityInfo> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        CommunityInfo singleItem = itemsList.get(i);
        holder.tvTitle.setText(singleItem.getNamee());
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext,SongList.class));
                }
            });


        }

    }

}
