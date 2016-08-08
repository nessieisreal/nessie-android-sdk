package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * Created by kco942 on 4/9/15.
 */
public class Geocode {

    private float lng;
    private float lat;

    public Geocode(float lng, float lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "Geocode{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
