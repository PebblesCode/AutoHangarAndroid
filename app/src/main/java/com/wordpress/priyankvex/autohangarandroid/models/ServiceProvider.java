package com.wordpress.priyankvex.autohangarandroid.models;

/**
 * Created by @priyankvex on 17/2/16.
 * Model to hold service provider
 */
public class ServiceProvider {

    private String name;
    private String address;
    private String city;
    private String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
