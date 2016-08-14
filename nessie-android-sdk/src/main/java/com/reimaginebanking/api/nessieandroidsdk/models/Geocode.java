package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * A class representing a Geocode object.
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
