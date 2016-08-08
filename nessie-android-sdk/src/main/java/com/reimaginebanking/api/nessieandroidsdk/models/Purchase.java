package com.reimaginebanking.api.nessieandroidsdk.models;


import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionType;

/**
 * Created by hxp347 on 9/3/15.
 */
public class Purchase {
    private String _id;
    private String purchase_date;
    private String status;
    private TransactionType type;
    private String payer_id;
    private String merchant_id;
    private double amount;
    private String description;
    private String medium;

    public Purchase(Builder builder){
        this.status = builder.status;
        this.merchant_id = builder.merchant_id;
        this.purchase_date = builder.purchase_date;
        this.amount = builder.amount;
        this.description = builder.description;
        this.medium = builder.medium;
    }

    public Purchase(String _id, String purchase_date, String status, TransactionType type, String payer_id, String merchant_id, double amount, String description, String medium) {
        this._id = _id;
        this.purchase_date = purchase_date;
        this.status = status;
        this.type = type;
        this.payer_id = payer_id;
        this.merchant_id = merchant_id;
        this.amount = amount;
        this.description = description;
        this.medium = medium;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(String payer_id) {
        this.payer_id = payer_id;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "_id='" + _id + '\'' +
                ", purchase_date='" + purchase_date + '\'' +
                ", status='" + status + '\'' +
                ", type=" + type +
                ", payer_id='" + payer_id + '\'' +
                ", merchant_id='" + merchant_id + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", medium=" + medium +

                '}';
    }

    public static class Builder{
        private String status;
        private String purchase_date;
        private double amount;
        private String merchant_id;
        private String description;
        private String medium;

        public Builder(){}

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder merchant(String merchant_id){
            this.merchant_id = merchant_id;
            return this;
        }
        public Builder purchase_date(String purchase_date){
            this.purchase_date = purchase_date;
            return this;
        }

        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder medium(String medium) {
            this.medium = medium;
            return this;
        }

        public Purchase build(){
            Purchase purchase = new Purchase(this);
            return purchase;
        }
    }
}
