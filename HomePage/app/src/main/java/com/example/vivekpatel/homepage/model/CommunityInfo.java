package com.example.vivekpatel.homepage.model;

import android.widget.ImageView;

/**
 * Created by VIVEK PATEL on 3/20/2018.
 */

public class CommunityInfo {

    public String namee;
    public String description;
    public String likes;
    public String comments;
    public String star;
    public ImageView profile;

    public CommunityInfo(String namee,String description,String likes,String comments,String star)
    {
        this.namee = namee;
        this.description = description;
        this.comments = comments;
        this.star = star;
        this.likes = likes;
    }
    public void setNamee(String songName)
    {
        this.namee = songName;
    }
    public String getNamee()
    {
        return this.namee;
    }
    public void setLikes(String likes)
    {
        this.likes = likes;
    }
    public String getLikes()
    {
        return this.likes;
    }
    public void setComments(String comments)
    {
        this.comments = comments;
    }
    public String getComments()
    {
        return this.comments;
    }
    public void setStar(String star)
    {
        this.star = star;
    }
    public String getStar()
    {
        return this.star;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getDescription()
    {
        return this.description;
    }
}
