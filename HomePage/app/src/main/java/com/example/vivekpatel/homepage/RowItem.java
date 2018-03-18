package com.example.vivekpatel.homepage;

import android.widget.TextView;

/**
 * Created by VIVEK PATEL on 3/14/2018.
 */

public class RowItem {

    String number;
    String song;
    String songDetail;

    public RowItem(String song, String title, String desc) {
        this.song = song;
        this.songDetail = title;
        this.number = desc;
    }
    public String getCount() {
        return number;
    }
    public void setSong(String song) {
        this.song = song;
    }
    public String getSongDetail() {
        return songDetail;
    }
    public void setSongDetail(String Songdetail) {
        this.songDetail = Songdetail;
    }
    public String getSong() {
        return song;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
