package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

/**
 * A class representing an Customer object.
 */
public class Customer {

    @SerializedName("_id")
    private String mId;

    @SerializedName("first_name")
    private String mFirstName;

    @SerializedName("last_name")
    private String mLastName;

    @SerializedName("address")
    private Address mAddress;

    public Customer(Address address){
        this.mAddress = address;
    }

    public Customer(String _id, String first_name, String last_name, Address address) {
        mId = _id;
        mFirstName = first_name;
        mLastName = last_name;
        mAddress = address;
    }

    public Customer(Builder builder){
        mFirstName = builder.bFirstName;
        mLastName = builder.bLastName;
        mAddress = builder.bAddress;
    }

    public String getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public Address getAddress() {
        return mAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "mId='" + mId + '\'' +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mAddress=" + mAddress +
                '}';
    }

    public static class Builder{
        private String bFirstName;
        private String bLastName;
        private Address bAddress;

        public Builder(){}

        public Builder(Customer customer) {
            bFirstName = customer.getFirstName();
            bLastName = customer.getLastName();
            bAddress = customer.getAddress();
        }

        public Builder firstName(String firstName){
            bFirstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            bLastName = lastName;
            return this;
        }

        public Builder address(Address address){
            bAddress = address;
            return this;
        }

        public Customer build(){
            Customer customer = new Customer(this);
            return customer;
        }
    }
}