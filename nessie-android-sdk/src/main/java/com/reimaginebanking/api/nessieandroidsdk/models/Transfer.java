package com.reimaginebanking.api.nessieandroidsdk.models;


import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionType;

/**
 * A class representing a Transfer object.
 */
public class Transfer {

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

    @SerializedName("payee_id")
    private String mPayeeId;

    @SerializedName("amount")
    private Double mAmount;

    @SerializedName("description")
    private String mDescription;

    public Transfer(Builder builder){
        mStatus = builder.bStatus;
        mMedium = builder.bMedium;
        mPayeeId = builder.bPayeeId;
        mAmount = builder.bAmount;
        mDescription = builder.bDescription;
        mTransactionDate = builder.bTransactionDate;
    }

    public Transfer(String _id, String transaction_date, String status, TransactionType type, TransactionMedium medium, String payer_id, String payee_id, double amount, String description) {
        mId = _id;
        mTransactionDate = transaction_date;
        mStatus = status;
        mType = type;
        mMedium = medium;
        mPayerId = payer_id;
        mPayeeId = payee_id;
        mAmount = amount;
        mDescription = description;
    }

    public Double getAmount() {
        return mAmount;
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

    public TransactionMedium getMedium(){
        return mMedium;
    }

    public String getPayerId() {
        return mPayerId;
    }

    public String getPayeeId() {
        return mPayeeId;
    }

    public String getDescription(){
        return mDescription;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "mId='" + mId + '\'' +
                ", transactionDate='" + mTransactionDate + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mType='" + mType + '\'' +
                ", mPayerId='" + mPayerId + '\'' +
                ", mPayeeId='" + mPayeeId + '\'' +
                ", mAmount=" + mAmount +
                ", mDescription=" + mDescription +
                '}';
    }

    public static class Builder{
        private String bStatus;
        private String bPayeeId;
        private Double bAmount;
        private TransactionMedium bMedium;
        private String bDescription;
        private String bTransactionDate;

        public Builder(){}

        public Builder(Transfer transfer) {
            bStatus = transfer.getStatus();
            bPayeeId = transfer.getPayeeId();
            bAmount = transfer.getAmount();
            bMedium = transfer.getMedium();
            bDescription = transfer.getDescription();
            bTransactionDate = transfer.getTransactionDate();
        }

        public Builder status(String status){
            bStatus = status;
            return this;
        }

        public Builder medium(TransactionMedium medium){
            bMedium = medium;
            return this;
        }
        public Builder payeeId(String payee_id){
            bPayeeId = payee_id;
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

        public Builder transactionDate(String transaction_date){
            bTransactionDate = transaction_date;
            return this;
        }

        public Transfer build(){
            Transfer transfer = new Transfer(this);
            return transfer;
        }
    }
}
