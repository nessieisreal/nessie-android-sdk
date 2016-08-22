package com.reimaginebanking.api.nessieandroidsdk.models;


import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionType;

/**
 * A class representing a Deposit object.
 */
public class Deposit {

    @SerializedName("_id")
    private String mId;

    @SerializedName("transaction_date")
    private String mTransactionDate;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("type")
    private TransactionType mType;

    @SerializedName("medium")
    private TransactionMedium mMedium;

    @SerializedName("payee_id")
    private String mPayeeId;

    @SerializedName("amount")
    private Double mAmount;

    @SerializedName("description")
    private String mDescription;

    public Deposit(String _id, String transaction_date, String status, TransactionType type, TransactionMedium medium, String payee_id, double amount, String description) {
        mId = _id;
        mTransactionDate = transaction_date;
        mStatus = status;
        mType = type;
        mMedium = medium;
        mPayeeId = payee_id;
        mAmount = amount;
        mDescription = description;
    }

    public Deposit(Builder builder){
        mMedium = builder.bMedium;
        mTransactionDate = builder.bTransactionDate;
        mAmount = builder.bAmount;
        mDescription = builder.bDescription;
    }

    public String getId() {
        return mId;
    }

    public String getTransactionDate() {
        return mTransactionDate;
    }

    public String getStatus() {
        return mStatus;
    }

    public TransactionType getType() {
        return mType;
    }

    public TransactionMedium getMedium() {
        return mMedium;
    }

    public String getPayee_id() {
        return mPayeeId;
    }

    public Double getAmount() {
        return mAmount;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "mId='" + mId + '\'' +
                ", mTransactionDate='" + mTransactionDate + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mType=" + mType +
                ", mMedium=" + mMedium +
                ", mPayeeId='" + mPayeeId + '\'' +
                ", mAmount=" + mAmount +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }

    public static class Builder{
        private String bTransactionDate;
        private Double bAmount;
        private TransactionMedium bMedium;
        private String bDescription;

        public Builder(){}

        public Builder(Deposit deposit) {
            bTransactionDate = deposit.getTransactionDate();
            bAmount = deposit.getAmount();
            bMedium = deposit.getMedium();
            bDescription = deposit.getDescription();
        }

        public Builder medium(TransactionMedium medium){
            bMedium = medium;
            return this;
        }
        public Builder transactionDate(String transaction_date){
            bTransactionDate = transaction_date;
            return this;
        }

        public Builder amount(double amount){
            bAmount = amount;
            return this;
        }

        public Builder description(String description){
            bDescription = description;
            return this;
        }

        public Deposit build(){
            Deposit deposit = new Deposit(this);
            return deposit;
        }
    }
}
