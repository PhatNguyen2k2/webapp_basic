package com.example.models;

public class Beer {
    int beerThumb;
    String beerName;

    public int getBeerThumb() {
        return beerThumb;
    }

    public void setBeerThumb(int beerThumb) {
        this.beerThumb = beerThumb;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public Beer(int beerThumb, String beerName) {
        this.beerThumb = beerThumb;
        this.beerName = beerName;
    }

}
