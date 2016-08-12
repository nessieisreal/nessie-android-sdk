package com.reimaginebanking.api.nessieandroidsdk.models;


import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionType;

/**
 * A class representing a Withdrawal object.
 */
public class Withdrawal {

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

    @SerializedName("payer_id")
    private String mPayerId;

    @SerializedName("amount")
    private double mAmount;

    @SerializedName("description")
    private String mDescription;

    public Withdrawal(Builder builder){
        mStatus = builder.bStatus;
        mMedium = builder.bMedium;
        mAmount = builder.bAmount;
        mDescription = builder.bDescription;
        mTransactionDate = builder.bTransactionDate;
    }

    public Withdrawal(String _id, String transaction_date, String status, TransactionType type, TransactionMedium medium, String payer_id, double amount, String description) {
        mId = _id;
        mTransactionDate = transaction_date;
        mStatus = status;
        mType = type;
        mMedium = medium;
        mPayerId = payer_id;
        mAmount = amount;
        mDescription = description;
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

    public String getPayerId() {
        return mPayerId;
    }

    public double getAmount() {
        return mAmount;
    }

    public String getDescription() {
        return mDescription;
    }


    @Override
    public String toString() {
        return "Withdrawal{" +
                "mId='" + mId + '\'' +
                ", transactionDate='" + mTransactionDate + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mType=" + mType +
                ", mMedium=" + mMedium +
                ", mPayerId='" + mPayerId + '\'' +
                ", mAmount=" + mAmount +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }

    public static class Builder{
        private String bStatus;
        private double bAmount;
        private TransactionMedium bMedium;
        private String bDescription;
        private String bTransactionDate;

        public Builder(){}

        public Builder(Withdrawal withdrawal) {
            bStatus = withdrawal.getStatus();
            bAmount = withdrawal.getAmount();
            bMedium = withdrawal.getMedium();
            bDescription = withdrawal.getDescription();
            bTransactionDate = withdrawal.getTransactionDate();
        }

        public Builder status(String status){
            this.bStatus = status;
            return this;
        }

        public Builder medium(TransactionMedium medium){
            this.bMedium = medium;
            return this;
        }

        public Builder amount(double amount){
            this.bAmount = amount;
            return this;
        }

        public Builder description(String description){
            this.bDescription = description;
            return this;
        }

        public Builder transaction_date(String transaction_date){
            this.bTransactionDate = transaction_date;
            return this;
        }

        public Withdrawal build(){
            Withdrawal withdrawal = new Withdrawal(this);
            return withdrawal;
        }
    }
}
