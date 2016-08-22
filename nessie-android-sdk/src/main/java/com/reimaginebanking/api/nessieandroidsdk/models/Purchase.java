package com.reimaginebanking.api.nessieandroidsdk.models;


import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.constants.TransactionType;

/**
 * A class representing a Purchase object.
 */
public class Purchase {

    @SerializedName("_id")
    private String mId;

    @SerializedName("purchase_date")
    private String mPurchaseDate;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("type")
    private TransactionType mType;

    @SerializedName("payer_id")
    private String mPayerId;

    @SerializedName("merchant_id")
    private String mMerchantId;

    @SerializedName("amount")
    private Double mAmount;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("medium")
    private String mMedium;

    public Purchase(String _id, String purchase_date, String status, TransactionType type, String payer_id, String merchant_id, double amount, String description, String medium) {
        mId = _id;
        mPurchaseDate = purchase_date;
        mStatus = status;
        mType = type;
        mPayerId = payer_id;
        mMerchantId = merchant_id;
        mAmount = amount;
        mDescription = description;
        mMedium = medium;
    }

    public Purchase(Builder builder){
        mMerchantId = builder.bMerchantId;
        mPurchaseDate = builder.bPurchaseDate;
        mAmount = builder.bAmount;
        mDescription = builder.bDescription;
        mMedium = builder.bMedium;
    }

    public String getId() {
        return mId;
    }

    public String getPurchaseDate() {
        return mPurchaseDate;
    }

    public String getStatus() {
        return mStatus;
    }

    public TransactionType getType() {
        return mType;
    }

    public String getPayerId() {
        return mPayerId;
    }

    public String getMerchantId() {
        return mMerchantId;
    }

    public Double getAmount() {
        return mAmount;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getMedium() {
        return mMedium;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "mId='" + mId + '\'' +
                ", mPurchaseDate='" + mPurchaseDate + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mType=" + mType +
                ", mPayerId='" + mPayerId + '\'' +
                ", mMerchantId='" + mMerchantId + '\'' +
                ", mAmount=" + mAmount +
                ", mDescription='" + mDescription + '\'' +
                ", mMedium=" + mMedium +

                '}';
    }

    public static class Builder{
        private String bPurchaseDate;
        private Double bAmount;
        private String bMerchantId;
        private String bDescription;
        private String bMedium;

        public Builder(){}

        public Builder(Purchase purchase) {
            bPurchaseDate = purchase.getPurchaseDate();
            bAmount = purchase.getAmount();
            bMerchantId = purchase.getMerchantId();
            bDescription = purchase.getDescription();
            bMedium = purchase.getMedium();
        }

        public Builder merchant(String merchant_id){
            bMerchantId = merchant_id;
            return this;
        }

        public Builder purchaseDate(String purchase_date){
            bPurchaseDate = purchase_date;
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

        public Builder medium(String medium) {
            bMedium = medium;
            return this;
        }

        public Purchase build(){
            Purchase purchase = new Purchase(this);
            return purchase;
        }
    }
}
