package com.reimaginebanking.api.nessieandroidsdk.models;

/**
 * Created by hxp347 on 9/3/15.
 */
public class Merchant {
    private String _id;
    private String name;
    private Address address;
    private Geocode geocode;

    public Merchant(Builder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.geocode = builder.geocode;
    }

    public Merchant(String _id, String name, Address address, Geocode geocode) {
        this._id = _id;
        this.name = name;
        this.address = address;
        this.geocode = geocode;
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

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", geocode=" + geocode +
                '}';
    }

    public static class Builder{
        private String name;
        private Address address;
        private Geocode geocode;

        public Builder(){}

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }
        public Builder geocode(Geocode geocode){
            this.geocode = geocode;
            return this;
        }

        public Merchant build(){
            Merchant merchant = new Merchant(this);
            return merchant;
        }
    }
}
