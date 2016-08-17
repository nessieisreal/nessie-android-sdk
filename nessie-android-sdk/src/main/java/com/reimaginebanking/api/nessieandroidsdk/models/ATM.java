package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A class representing an ATM object.
 */
public class ATM {

    @SerializedName("_id")
    private String mId;

    @SerializedName("accessibility")
    private Boolean mAccessibility;

    @SerializedName("name")
    private String mName;

    @SerializedName("language_list")
    private List<String> mLanguageList;

    @SerializedName("hours")
    private List<String> mHours;

    @SerializedName("address")
    private Address mAddress;

    @SerializedName("amount_left")
    private long mAmountLeft;

    @SerializedName("geocode")
    private Geocode mGeocode;


    public ATM(String _id, Boolean accessibility, String name, List<String> language_list, List<String> hours, Address address, long amount_left, Geocode geocode) {
        mId = _id;
        mAccessibility = accessibility;
        mName = name;
        mLanguageList = language_list;
        mHours = hours;
        mAddress = address;
        mAmountLeft = amount_left;
        mGeocode = geocode;
    }

    public String getId() {
        return mId;
    }

    public Boolean getAccessibility() {
        return mAccessibility;
    }

    public String getName() {
        return mName;
    }

    public List<String> getLanguageList() {
        return mLanguageList;
    }

    public List<String> getHours() {
        return mHours;
    }

    public Address getAddress() {
        return mAddress;
    }

    public long getAmountLeft() {
        return mAmountLeft;
    }

    public Geocode getGeocode() {
        return mGeocode;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "mId='" + mId + '\'' +
                ", mAccessibility='" + mAccessibility + '\'' +
                ", mName='" + mName + '\'' +
                ", mLanguageList=" + mLanguageList +
                ", mHours=" + mHours +
                ", mAddress=" + mAddress +
                ", mAmountLeft=" + mAmountLeft +
                ", mGeocode=" + mGeocode +
                '}';
    }
}
