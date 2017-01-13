package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.constants.AccountType;

/**
 * A class representing an Account object.
 */
public class Account {

    @SerializedName("_id")
    private String mId;

    @SerializedName("type")
    private AccountType mType;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("rewards")
    private Double mRewards;

    @SerializedName("balance")
    private Double mBalance;

    @SerializedName("account_number")
    private String mAccountNumber;

    @SerializedName("customer_id")
    private String mCustomer;

    public Account(String _id, AccountType type, String nickname, double rewards, double balance, String account_number, String customer) {
        mId = _id;
        mType = type;
        mNickname = nickname;
        mRewards = rewards;
        mBalance = balance;
        mAccountNumber = account_number;
        mCustomer = customer;
    }

    public Account(Builder builder){
        mType = builder.bType;
        mNickname = builder.bNickname;
        mRewards = builder.bRewards;
        mBalance = builder.bBalance;
        mAccountNumber = builder.bAccountNumber;
    }

    public String getId() {
        return mId;
    }

    public AccountType getType() {
        return mType;
    }

    public String getNickname() {
        return mNickname;
    }

    public Double getRewards() {
        return mRewards;
    }

    public Double getBalance() {
        return mBalance;
    }

    public String getAccountNumber() {
        return mAccountNumber;
    }

    public String getCustomer() {
        return mCustomer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "mId='" + mId + '\'' +
                ", mType='" + mType.toString() + '\'' +
                ", mNickname='" + mNickname + '\'' +
                ", mRewards=" + mRewards +
                ", mBalance=" + mBalance +
                ", mAccountNumber=" + mAccountNumber +
                ", mCustomer='" + mCustomer + '\'' +
                '}';
    }

    public static class Builder{
        private AccountType bType;
        private String bNickname;
        private Double bRewards;
        private Double bBalance;
        private String bAccountNumber;

        public Builder(){}

        public Builder(Account account) {
            bType = account.getType();
            bNickname = account.getNickname();
            bRewards = account.getRewards();
            bBalance = account.getBalance();
            bAccountNumber = account.getAccountNumber();
        }

        public Builder type(AccountType type){
            bType = type;
            return this;
        }

        public Builder nickname(String nickname){
            bNickname = nickname;
            return this;
        }

        public Builder rewards(double rewards){
            bRewards = rewards;
            return this;
        }

        public Builder balance(double balance){
            bBalance = balance;
            return this;
        }

        public Builder accountNumber(String account_number) {
            bAccountNumber = account_number;
            return this;
        }

        public Account build(){
            Account account = new Account(this);
            return account;
        }
    }
}
