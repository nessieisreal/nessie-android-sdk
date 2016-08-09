package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * An object representing a Customer from the API.
 */
public class Customer {
    private String _id;
    private String first_name;
    private String last_name;
    private Address address;

    public Customer(){
        _id = null;
        first_name = null;
        last_name = null;
        address = null;
    }

    public Customer(Address address){
        this.address = address;
    }

    public Customer(String _id, String first_name, String last_name, Address address) {
        this._id = _id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
    }

    public Customer(Builder builder){
        this.first_name = builder.firstName;
        this.last_name = builder.lastName;
        this.address = builder.address;
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

    @Override
    public String toString() {
        return "Customer{" +
                "_id='" + _id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private Address address;

        public Builder(){}

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public Customer build(){
            Customer customer = new Customer(this);
            return customer;
        }
    }
}