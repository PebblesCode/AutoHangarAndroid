package com.wordpress.priyankvex.autohangarandroid.models;

/**
 * Created by @priyankvex on 15/2/16.
 * Model to hold notification
 */
public class Notification {

    private String title;
    private String body;
    private String imageUrl;
    private long time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
