package com.reimaginebanking.api.nessieandroidsdk.models;

import com.reimaginebanking.api.nessieandroidsdk.Constants.BillStatus;

/**
 * Created by kco942 on 4/9/15.
 */
public class Bill {
    private String _id;
    private BillStatus status;
    private String payee;
    private String nickname;
    private String creation_date;
    private String payment_date;
    private int recurring_date;
    private String upcoming_payment_date;
    private double payment_amount;

    public Bill(){

    }

    public Bill(Builder builder){
        this.status = builder.status;
        this.payee = builder.payee;
        this.nickname = builder.nickname;
        this.payment_date = builder.payment_date;
        this.recurring_date = builder.recurring_date;
        this.payment_amount = builder.payment_amount;
    }

    public Bill(String _id, BillStatus status, String payee, String nickname, String creation_date, String payment_date, int recurring_date, String upcoming_payment_date, double payment_amount) {
        this._id = _id;
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creation_date = creation_date;
        this.payment_date = payment_date;
        this.recurring_date = recurring_date;
        this.upcoming_payment_date = upcoming_payment_date;
        this.payment_amount = payment_amount;
    }

    public String get_id() {
        return _id;
    }

    public BillStatus getStatus() {
        return status;
    }

    public String getPayee() {
        return payee;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public int getRecurring_date() {
        return recurring_date;
    }

    public String getUpcoming_payment_date() {
        return upcoming_payment_date;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public void setRecurring_date(int recurring_date) {
        this.recurring_date = recurring_date;
    }

    public void setUpcoming_payment_date(String upcoming_payment_date) {
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public void setPayment_amount(double payment_amount) {
        this.payment_amount = payment_amount;
    }

    @Override
    public String toString() {

        return "Bill{" +
                "_id='" + _id + '\'' +
                ", status='" + status + '\'' +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", recurring_date=" + recurring_date +
                ", upcoming_payment_date='" + upcoming_payment_date + '\'' +
                ", payment_amount=" + payment_amount +
                '}';
    }

    public static class Builder{
        private BillStatus status;
        private String payee;
        private String nickname;
        private String payment_date;
        private int recurring_date;
        private double payment_amount;

        public Builder(){}

        public Builder status(BillStatus status){
            this.status = status;
            return this;
        }

        public Builder payee(String payee){
            this.payee = payee;
            return this;
        }

        public Builder nickname(String nickname){
            this.nickname = nickname;
            return this;
        }

        public Builder payment_date(String payment_date){
            this.payment_date = payment_date;
            return this;
        }

        public Builder recurring_date(int recurring_date){
            this.recurring_date = recurring_date;
            return this;
        }

        public Builder payment_amount(double payment_amount){
            this.payment_amount = payment_amount;
            return this;
        }

        public Bill build(){
            Bill bill = new Bill(this);
            return bill;
        }
    }
}
