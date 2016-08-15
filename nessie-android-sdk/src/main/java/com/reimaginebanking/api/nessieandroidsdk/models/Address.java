package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * A class representing an Address object.
 */
public class Address {

    @SerializedName("street_number")
    private String mStreetNumber;

    @SerializedName("street_name")
    private String mStreetName;

    @SerializedName("city")
    private String mCity;

    @SerializedName("state")
    private String mState;

    @SerializedName("zip")
    private String mZip;

    public Address(String streetNumber, String streetName, String city, String state, String zip) {
        mState = state;
        mStreetName = streetName;
        mStreetNumber = streetNumber;
        mCity = city;
        mZip = zip;
    }

    public Address(Builder builder) {
        mState = builder.bState;
        mStreetName = builder.bStreetName;
        mStreetNumber = builder.bStreetNumber;
        mCity = builder.bCity;
        mZip = builder.bZip;
    }

    public String getStreetNumber(){
        return mStreetNumber;
    }

    public String getStreetName() {
        return mStreetName;
    }

    public String getCity() {
        return mCity;
    }

    public String getmState() {
        return mState;
    }

    public String getZip() {
        return mZip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "mStreetNumber='" + mStreetNumber + '\'' +
                ", mStreetName='" + mStreetName + '\'' +
                ", mCity='" + mCity + '\'' +
                ", mState='" + mState + '\'' +
                ", mZip='" + mZip + '\'' +
                '}';
    }

    public static class Builder {

        private String bStreetNumber;
        private String bStreetName;
        private String bCity;
        private String bState;
        private String bZip;

        public Builder() {}

        public Builder(Address address) {
            bStreetNumber = address.getStreetNumber();
            bStreetName = address.getStreetName();
            bCity = address.getCity();
            bState = address.getmState();
            bZip = address.getZip();
        }

        public Builder streetNumber(String streetNumber) {
            bStreetNumber = streetNumber;
            return this;
        }

        public Builder streetName(String streetName) {
            bStreetName = streetName;
            return this;
        }

        public Builder city(String city) {
            bCity = city;
            return this;
        }

        public Builder state(String state) {
            bState = state;
            return this;
        }

        public Builder zip(String zip) {
            bZip = zip;
            return this;
        }

        public Address build(){
            Address address = new Address(this);
            return address;
        }
    }
}
