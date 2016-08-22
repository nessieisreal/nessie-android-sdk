package com.reimaginebanking.api.nessieandroidsdk.models;


import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionType;

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

    public Transfer(Builder builder){
        mMedium = builder.bMedium;
        mPayeeId = builder.bPayeeId;
        mAmount = builder.bAmount;
        mDescription = builder.bDescription;
        mTransactionDate = builder.bTransactionDate;
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

    public Double getAmount() {
        return mAmount;
    }

    public String getDescription(){
        return mDescription;
    }



    public static class Builder{
        private String bTransactionDate;
        private TransactionMedium bMedium;
        private String bPayeeId;
        private Double bAmount;
        private String bDescription;

        public Builder(){}

        public Builder(Transfer transfer) {
            bTransactionDate = transfer.getTransactionDate();
            bMedium = transfer.getMedium();
            bPayeeId = transfer.getPayeeId();
            bAmount = transfer.getAmount();
            bDescription = transfer.getDescription();

        }

        public Builder transactionDate(String transaction_date){
            bTransactionDate = transaction_date;
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

        public Transfer build(){
            Transfer transfer = new Transfer(this);
            return transfer;
        }
    }
}
