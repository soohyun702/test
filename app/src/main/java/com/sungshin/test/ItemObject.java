package com.sungshin.test;

import android.net.Uri;

public class ItemObject {
    private String title;
    private String score;
    private Uri photo;

    public ItemObject(String title, String score, Uri photo) {
        this.title = title;
        this.score = score;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.title = score;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }
}