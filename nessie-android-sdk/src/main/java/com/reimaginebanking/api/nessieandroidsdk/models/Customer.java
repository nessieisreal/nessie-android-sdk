package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Customer {
    private String _id;
    private String first_name;
    private String last_name;
    private Address address;
    @SerializedName("account_ids")
    private List<String> accounts;

    public Customer(){
        _id = null;
        first_name = null;
        last_name = null;
        address = null;
        accounts = null;
    }

    public Customer(Address address){
        this.address = address;
    }

    public Customer(String _id, String first_name, String last_name, Address address, List<String> accounts) {
        this._id = _id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.accounts = accounts;
    }

    public String get_id() {
        return _id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "_id='" + _id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address=" + address +
                ", accounts=" + accounts +
                '}';
    }
}