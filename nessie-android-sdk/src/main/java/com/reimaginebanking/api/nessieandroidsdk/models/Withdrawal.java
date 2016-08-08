package com.reimaginebanking.api.nessieandroidsdk.models;


import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionType;

/**
 * Created by hxp347 on 9/3/15.
 */
public class Withdrawal {
    private String _id;
    private String transaction_date;
    private String status;
    private TransactionType type;
    private TransactionMedium medium;
    private String payer_id;
    private double amount;
    private String description;

    public Withdrawal(Builder builder){
        this.status = builder.status;
        this.medium = builder.medium;
        this.amount = builder.amount;
        this.description = builder.description;
        this.transaction_date = builder.transaction_date;
    }

    public Withdrawal(String _id, String transaction_date, String status, TransactionType type, TransactionMedium medium, String payer_id, double amount, String description) {
        this._id = _id;
        this.transaction_date = transaction_date;
        this.status = status;
        this.type = type;
        this.medium = medium;
        this.payer_id = payer_id;
        this.amount = amount;
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
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

    public TransactionMedium getMedium() {
        return medium;
    }

    public void setMedium(TransactionMedium medium) {
        this.medium = medium;
    }

    public String getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(String payer_id) {
        this.payer_id = payer_id;
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

    @Override
    public String toString() {
        return "Withdrawal{" +
                "_id='" + _id + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", type=" + type +
                ", medium=" + medium +
                ", payer_id='" + payer_id + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private String status;
        private double amount;
        private TransactionMedium medium;
        private String description;
        private String transaction_date;

        public Builder(){}

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder medium(TransactionMedium medium){
            this.medium = medium;
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

        public Builder transaction_date(String transaction_date){
            this.transaction_date = transaction_date;
            return this;
        }

        public Withdrawal build(){
            Withdrawal withdrawal = new Withdrawal(this);
            return withdrawal;
        }
    }
}
