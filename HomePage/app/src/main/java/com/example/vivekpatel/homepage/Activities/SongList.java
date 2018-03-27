package com.example.vivekpatel.homepage.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.vivekpatel.homepage.fragments.Community;
import com.example.vivekpatel.homepage.fragments.Home;
import com.example.vivekpatel.homepage.fragments.LiveShows;
import com.example.vivekpatel.homepage.Adapters.MusicList;
import com.example.vivekpatel.homepage.fragments.Originals;
import com.example.vivekpatel.homepage.R;
import com.example.vivekpatel.homepage.model.SongInfo;

import java.util.ArrayList;
import java.util.List;

public class SongList extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;
    private MusicList adapter;
    private List<SongInfo> songList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        recyclerView = (RecyclerView) findViewById(R.id.view_to_play);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //    img  = (ImageView) findViewById(R.id.img_show);
        getSupportActionBar().setHomeButtonEnabled(true);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("LIST OF SONGS");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        songList = new ArrayList<>();
        adapter = new MusicList(this,songList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareSongs();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void prepareSongs() {
        SongInfo a = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a);
        SongInfo a1 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a1);
        SongInfo a2 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a2);
        SongInfo a3 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a3);
        SongInfo a4 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a4);
        SongInfo a5 =new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a5);
        SongInfo a6 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a6);
        SongInfo a7 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a7);
        SongInfo a8 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a8);
        SongInfo a9 = new SongInfo("Quora Qaagaz","Session-Session2","2:10 min");
        songList.add(a9);
        adapter.notifyDataSetChanged();
    } @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        android.support.v4.app.Fragment fragment = null;
        int id = item.getItemId();
        switch(id) {
            case R.id.Originals:
                fragment = new Originals();
                break;
            case R.id.Home:
                fragment = new Home();
                break;
            case R.id.LiveShows:
                fragment = new LiveShows();
                break;
            case R.id.Community:
                fragment = new Community();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContent, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
