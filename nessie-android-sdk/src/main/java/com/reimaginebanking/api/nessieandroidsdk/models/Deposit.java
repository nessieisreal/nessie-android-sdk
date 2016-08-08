package com.reimaginebanking.api.nessieandroidsdk.models;


import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionMedium;
import com.reimaginebanking.api.nessieandroidsdk.Constants.TransactionType;

/**
 * Created by hxp347 on 9/3/15.
 */
public class Deposit {
    private String _id;
    private String transaction_date;
    private String status;
    private TransactionType type;
    private TransactionMedium medium;
    private String payee_id;
    private double amount;
    private String description;

    public Deposit(Builder builder){
        this.status = builder.status;
        this.medium = builder.medium;
        this.transaction_date = builder.transaction_date;
        this.amount = builder.amount;
        this.description = builder.description;
    }

    public Deposit(String _id, String transaction_date, String status, TransactionType type, TransactionMedium medium, String payee_id, double amount, String description) {
        this._id = _id;
        this.transaction_date = transaction_date;
        this.status = status;
        this.type = type;
        this.medium = medium;
        this.payee_id = payee_id;
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

    public String getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(String payee_id) {
        this.payee_id = payee_id;
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
        return "Deposit{" +
                "_id='" + _id + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", status='" + status + '\'' +
                ", type=" + type +
                ", medium=" + medium +
                ", payee_id='" + payee_id + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder{
        private String status;
        private String transaction_date;
        private double amount;
        private TransactionMedium medium;
        private String description;

        public Builder(){}

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder medium(TransactionMedium medium){
            this.medium = medium;
            return this;
        }
        public Builder transaction_date(String transaction_date){
            this.transaction_date = transaction_date;
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

        public Deposit build(){
            Deposit deposit = new Deposit(this);
            return deposit;
        }
    }
}
