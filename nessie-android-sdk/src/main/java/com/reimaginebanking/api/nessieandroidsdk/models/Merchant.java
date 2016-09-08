package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A class representing a Merchant object.
 */
public class Merchant {

    @SerializedName("_id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("category")
    private List<String> mCategories;

    @SerializedName("address")
    private Address mAddress;

    @SerializedName("geocode")
    private Geocode mGeocode;

    public Merchant(Builder builder){
        mName = builder.bName;
        mCategories = builder.bCategories;
        mAddress = builder.bAddress;
        mGeocode = builder.bGeocode;
    }

    public Merchant(String _id, String name, List<String> categories, Address address, Geocode geocode) {
        mId = _id;
        mName = name;
        mCategories = categories;
        mAddress = address;
        mGeocode = geocode;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public List<String> getCategories() { return mCategories; }

    public Address getAddress() {
        return mAddress;
    }

    public Geocode getGeocode() {
        return mGeocode;
    }

    @Override
    public String toString() {
        return "Merchant{" +
            "mId='" + mId + '\'' +
            ", mName='" + mName + '\'' +
            ", mCategory='" + mCategories + '\'' +
            ", mAddress=" + mAddress +
            ", mGeocode=" + mGeocode +
            '}';
    }

    public static class Builder{
        private String bName;
        private List<String> bCategories;
        private Address bAddress;
        private Geocode bGeocode;

        public Builder(){}

        public Builder(Merchant merchant) {
            bName = merchant.getName();
            bCategories = merchant.getCategories();
            bAddress = merchant.getAddress();
            bGeocode = merchant.getGeocode();
        }

        public Builder name(String name){
            this.bName = name;
            return this;
        }

        public Builder categories(List<String> categories) {
            this.bCategories = categories;
            return this;
        }

        public Builder address(Address address){
            this.bAddress = address;
            return this;
        }
        public Builder geocode(Geocode geocode){
            this.bGeocode = geocode;
            return this;
        }

        public Merchant build(){
            Merchant merchant = new Merchant(this);
            return merchant;
        }
    }
}
