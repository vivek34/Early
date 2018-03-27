package com.example.vivekpatel.homepage.Activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vivekpatel.homepage.Adapters.TrendingAdapter;
import com.example.vivekpatel.homepage.fragments.Community;
import com.example.vivekpatel.homepage.fragments.Home;
import com.example.vivekpatel.homepage.fragments.LiveShows;
import com.example.vivekpatel.homepage.fragments.Originals;
import com.example.vivekpatel.homepage.R;
import com.example.vivekpatel.homepage.model.SectionDataModel;
import com.example.vivekpatel.homepage.model.SingleItemModel;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    private Toolbar toolbar;

    ImageView img;
    NavigationView navigationView;
    ArrayList<SectionDataModel> SampleData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        DrawerLayout mdrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //    img  = (ImageView) findViewById(R.id.img_show);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");
        SampleData = new ArrayList<SectionDataModel>();
        Shows_Data();
        RecyclerView my_recycler_view = (RecyclerView)findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        TrendingAdapter adapter = new TrendingAdapter(this,SampleData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
        navigationView = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(navigationView);
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
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem item) {
        DrawerLayout mdrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Create a new fragment and specify the fragment to show based on nav item clicked
        android.support.v4.app.Fragment fragment = null;
        int id = item.getItemId();
        Class fragmentClass = null;
        switch (id) {
            case R.id.Originals:
                Log.d("Vivek","clicked");
                fragmentClass = Originals.class;
                break;
            case R.id.Home:
                fragmentClass = Home.class;
                break;
            case R.id.LiveShows:
                fragmentClass = LiveShows.class;
                break;
            case R.id.Community:
                fragmentClass = Community.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        item.setChecked(true);
        // Set action bar title
        setTitle(item.getTitle());
        // Close the navigation drawer
        mdrawer.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem actionViewItem = menu.findItem(R.id.miActionButton);
        // Retrieve the action-view from menu
        View v = MenuItemCompat.getActionView(actionViewItem);
        // Find the button within action-view
        Button b = (Button) v.findViewById(R.id.btnCustomAction);
        // Handle button click here
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AudioActivity.class);
                startActivity(i);
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}