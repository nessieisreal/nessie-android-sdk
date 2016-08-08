package com.reimaginebanking.api.nessieandroidsdk.models;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Branch {
    private String _id;
    private String name;
    private Address address;
    private String phone_number;
    private List<String> hours;

    public Branch(String _id, String name, Address address, String phone_number, List<String> hours) {
        this._id = _id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.hours = hours;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public List<String> getHours() {
        return hours;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone_number='" + phone_number + '\'' +
                ", hours=" + hours +
                '}';
    }
}
