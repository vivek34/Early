package com.example.vivekpatel.homepage.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.vivekpatel.homepage.R;

public class Description extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 5000;
    private TextView mContentView1,mContentView2,mContentView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.description);
        mContentView1 = (TextView) findViewById(R.id.fullscreen_content);
        mContentView2 = (TextView) findViewById(R.id.fullscreen_content1);
        mContentView3 = (TextView) findViewById(R.id.fullscreen_content2);
        mContentView1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_center_from_bottom));
        mContentView2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_center_from_top));
        mContentView3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_bottom));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),MainScreen.class);
                Description.this.startActivity(mainIntent);
                Description.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}