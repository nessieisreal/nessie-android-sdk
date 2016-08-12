package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.Constants.AccountType;

/**
 * Created by kco942 on 4/9/15.
 */
public class Account {

    private String _id;
    private AccountType type;
    private String nickname;
    private int rewards;
    private int balance;
    private String account_number;
    @SerializedName("customer_id")
    private String customer;

    public Account(Builder builder){
        this.type = builder.type;
        this.nickname = builder.nickname;
        this.rewards = builder.rewards;
        this.balance = builder.balance;
        this.account_number = builder.account_number;
    }

    public Account(String _id, AccountType type, String nickname, int rewards, int balance, String account_number, String customer) {
        this._id = _id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.account_number = account_number;
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

    public String getAccountNumber() {
        return account_number;
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
                ", account_number=" + account_number +
                ", customer='" + customer + '\'' +
                '}';
    }

    public static class Builder{
        private AccountType type;
        private String nickname;
        private int rewards;
        private int balance;
        private String account_number;

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

        public Builder balance(int balance){
            this.balance = balance;
            return this;
        }

        public Builder accountNumber(String account_number) {
            this.account_number = account_number;
            return this;
        }

        public Account build(){
            Account account = new Account(this);
            return account;
        }
    }
}
