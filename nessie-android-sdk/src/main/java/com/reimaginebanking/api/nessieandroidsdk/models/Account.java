package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.Constants.AccountType;

import java.util.List;

/**
 * Created by kco942 on 4/9/15.
 */
public class Account {

    private String _id;
    private AccountType type;
    private String nickname;
    private int rewards;
    private double balance;
    private List<String> bill_ids;
    @SerializedName("customer_id")
    private String customer;

    public Account(Builder builder){
        this.type = builder.type;
        this.nickname = builder.nickname;
        this.rewards = builder.rewards;
        this.balance = builder.balance;
    }

    public Account(AccountType type, String nickname, int rewards, double balance, List<String> bill_ids, String customer) {
        this._id = _id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.bill_ids = bill_ids;
        this.customer = customer;
    }

    public String get_id() {
        return _id;
    }

    public AccountType getType() {
        return type;
    }

    public String getNickname() {
        return nickname;
    }

    public int getRewards() {
        return rewards;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getBill_ids() {
        return bill_ids;
    }

    public String getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "_id='" + _id + '\'' +
                ", type='" + type.toString() + '\'' +
                ", nickname='" + nickname + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", bill_ids=" + bill_ids +
                ", customer='" + customer + '\'' +
                '}';
    }

    public static class Builder{
        private AccountType type;
        private String nickname;
        private int rewards;
        private double balance;

        public Builder(){}

        public Builder type(AccountType type){
            this.type = type;
            return this;
        }

        public Builder nickname(String nickname){
            this.nickname = nickname;
            return this;
        }

        public Builder rewards(int rewards){
            this.rewards = rewards;
            return this;
        }

        public Builder balance(double balance){
            this.balance = balance;
            return this;
        }

        public Account build(){
            Account account = new Account(this);
            return account;
        }
    }
}
