package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * A class representing an Address object.
 */
public class Address {

    @SerializedName("state")
    private String mState;

    @SerializedName("street_name")
    private String mStreetName;

    @SerializedName("street_number")
    private String mStreetNumber;

    @SerializedName("city")
    private String mCity;

    @SerializedName("zip")
    private String mZip;

    public Address(String state, String streetName, String streetNumber, String city, String zip) {
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

    public String getmState() {
        return mState;
    }

    public String getStreetName() {
        return mStreetName;
    }

    public String getStreetNumber(){
        return mStreetNumber;
    }

    public String getCity() {
        return mCity;
    }

    public String getZip() {
        return mZip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "mState='" + mState + '\'' +
                ", mStreetName='" + mStreetName + '\'' +
                ", mStreetNumber='" + mStreetNumber + '\'' +
                ", mCity='" + mCity + '\'' +
                ", mZip='" + mZip + '\'' +
                '}';
    }

    public static class Builder {

        private String bState;
        private String bStreetName;
        private String bStreetNumber;
        private String bCity;
        private String bZip;

        public Builder() {}

        public Builder(Address address) {
            bState = address.getmState();
            bStreetName = address.getStreetName();
            bStreetNumber = address.getStreetNumber();
            bCity = address.getCity();
            bZip = address.getZip();
        }

        public Builder state(String state) {
            bState = state;
            return this;
        }

        public Builder streetName(String streetName) {
            bStreetName = streetName;
            return this;
        }

        public Builder streetNumber(String streetNumber) {
            bStreetNumber = streetNumber;
            return this;
        }

        public Builder city(String city) {
            bCity = city;
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
