package com.example.vivekpatel.homepage;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;


    ArrayList<SectionDataModel> SampleData;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    //    img  = (ImageView) findViewById(R.id.img_show);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        SampleData = new ArrayList<SectionDataModel>();
        Shows_Data();
        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        TrendingAdapter adapter = new TrendingAdapter(this,SampleData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);

    }

    public void Shows_Data() {
        for (int i = 1; i <= 3; i++) {
            SectionDataModel dm = new SectionDataModel();
            if(i == 1)
            {
                dm.setHeaderTitle("TRENDING SONGS");
            }
            if(i==2)
            {
                dm.setHeaderTitle("RECENTLY HEARD");
            }
            if(i==3)
            {
                dm.setHeaderTitle("TRENDING SHOWS");
            }
            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }
            dm.setAllItemsInSection(singleItem);
            SampleData.add(dm);

        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
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