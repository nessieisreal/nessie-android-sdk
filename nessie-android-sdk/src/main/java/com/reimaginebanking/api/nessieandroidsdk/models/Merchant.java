package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * A class representing a Merchant object.
 */
public class Merchant {

    @SerializedName("_id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("category")
    private String mCategory;

    @SerializedName("address")
    private Address mAddress;

    @SerializedName("geocode")
    private Geocode mGeocode;

    public Merchant(Builder builder){
        mName = builder.bName;
        mCategory = builder.bCategory;
        mAddress = builder.bAddress;
        mGeocode = builder.bGeocode;
    }

    public Merchant(String _id, String name, String category, Address address, Geocode geocode) {
        mId = _id;
        mName = name;
        mCategory = category;
        mAddress = address;
        mGeocode = geocode;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getCategory() { return mCategory; }

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
            ", mCategory='" + mCategory + '\'' +
            ", mAddress=" + mAddress +
            ", mGeocode=" + mGeocode +
            '}';
    }

    public static class Builder{
        private String bName;
        private String bCategory;
        private Address bAddress;
        private Geocode bGeocode;

        public Builder(){}

        public Builder(Merchant merchant) {
            bName = merchant.getName();
            bCategory = merchant.getCategory();
            bAddress = merchant.getAddress();
            bGeocode = merchant.getGeocode();
        }

        public Builder name(String name){
            this.bName = name;
            return this;
        }

        public Builder category(String category) {
            this.bCategory = category;
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
