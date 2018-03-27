package com.example.vivekpatel.homepage.Activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.vivekpatel.homepage.R;

import java.io.File;
import java.io.IOException;

public class AudioActivity extends AppCompatActivity {
    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;

    boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
    }
    public void startRecording(View view) {
        requestAudioPermissions();
    }

    private void recordAudio() {
        if (mRecorder == null) {
            mRecorder = new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setOutputFile(getFilesDir()+"/audio.m4a");
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        }

        if (!isRecording) {
            try {
                mRecorder.prepare();
                mRecorder.start();
                isRecording = true;
            } catch (IOException e) {
                Log.e("Audio", "prepare() failed");
            }
        } else if (isRecording) {
            isRecording = false;
            stopRecording();
        }
    }

    public void stopRecording() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.reset();
            mRecorder.release();
            mRecorder = null;
        }
    }

    public void startPlaying(View view) {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(getFilesDir()+"/audio.m4a");
            Log.d("Vivek",String.valueOf(getFilesDir()));
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e("Audio", "prepare() failed");
        }
    }

    public void stopPlaying() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Override
    public void onDestroy() {

        if (mPlayer != null) {
            stopPlaying();
        }

        if (mRecorder != null) {
            stopRecording();
        }

        super.onDestroy();
    }
    private final int MY_PERMISSIONS_RECORD_AUDIO = 1;

    private void requestAudioPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {
                Toast.makeText(this, "Please grant permissions to record audio", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        MY_PERMISSIONS_RECORD_AUDIO);

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        MY_PERMISSIONS_RECORD_AUDIO);
            }
        }
        else if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_GRANTED) {
            recordAudio();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_RECORD_AUDIO: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    recordAudio();
                } else {
                    Toast.makeText(this, "Permissions Denied to record audio", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}
