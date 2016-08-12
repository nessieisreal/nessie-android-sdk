package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A class representing a Branch object.
 */
public class Branch {

    @SerializedName("_id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("address")
    private Address mAddress;

    @SerializedName("phone_number")
    private String mPhoneNumber;

    @SerializedName("hours")
    private List<String> mHours;

    public Branch(String _id, String name, Address address, String phone_number, List<String> hours) {
        mId = _id;
        mName = name;
        mAddress = address;
        mPhoneNumber = phone_number;
        mHours = hours;
    }

    public Branch(Builder builder) {
        mName = builder.bName;
        mAddress = builder.bAddress;
        mPhoneNumber = builder.bPhoneNumber;
        mHours = builder.bHours;
    }

    public String getId() {
        return mId;
    }

    public void setId(String _id) {
        mId = _id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        mPhoneNumber = phone_number;
    }

    public List<String> getHours() {
        return mHours;
    }

    public void setHours(List<String> hours) {
        mHours = hours;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mAddress=" + mAddress +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mHours=" + mHours +
                '}';
    }

    public static class Builder {

        private String bId;
        private String bName;
        private Address bAddress;
        private String bPhoneNumber;
        private List<String> bHours;

        public Builder name(String name) {
            bName = name;
            return this;
        }

        public Builder address(Address address) {
            bAddress = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            bPhoneNumber = phoneNumber;
            return this;
        }

        public Builder hours(List<String> hours) {
            bHours = hours;
            return this;
        }

    }
}
