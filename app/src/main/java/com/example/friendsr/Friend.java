package com.example.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    public String getName(){
        return name;
    }

    public String getBio(){
        return bio;
    }

    public int getDrawableId(){
        return drawableId;
    }

    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }
}
