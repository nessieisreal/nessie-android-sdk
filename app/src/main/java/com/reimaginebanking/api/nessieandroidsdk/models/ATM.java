package com.reimaginebanking.api.nessieandroidsdk.models;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class ATM {
    private String _id;
    private String accessibility;
    private String name;
    private List<String> language_list;
    private List<String> hours;
    private Address address;
    private long amount_left;
    private Geocode geocode;


    public ATM(String _id, String accessibility, String name, List<String> language_list, List<String> hours, Address address, long amount_left, Geocode geocode) {
        this._id = _id;
        this.accessibility = accessibility;
        this.name = name;
        this.language_list = language_list;
        this.hours = hours;
        this.address = address;
        this.amount_left = amount_left;
        this.geocode = geocode;
    }

    public String get_id() {
        return _id;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguage_list() {
        return language_list;
    }

    public List<String> getHours() {
        return hours;
    }

    public Address getAddress() {
        return address;
    }

    public long getAmount_left() {
        return amount_left;
    }

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "_id='" + _id + '\'' +
                ", accessibility='" + accessibility + '\'' +
                ", name='" + name + '\'' +
                ", language_list=" + language_list +
                ", hours=" + hours +
                ", address=" + address +
                ", amount_left=" + amount_left +
                ", geocode=" + geocode +
                '}';
    }
}
