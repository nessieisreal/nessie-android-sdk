package com.reimaginebanking.api.nessieandroidsdk.models;

import com.google.gson.annotations.SerializedName;

import com.reimaginebanking.api.nessieandroidsdk.Constants.BillStatus;

/**
 * A class representing a Bill object.
 */
public class Bill {

    @SerializedName("_id")
    private String mId;

    @SerializedName("status")
    private BillStatus mStatus;

    @SerializedName("payee")
    private String mPayee;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("creation_date")
    private String mCreationDate;

    @SerializedName("payment_ate")
    private String mPaymentDate;

    @SerializedName("recurringDate")
    private int mRecurringDate;

    @SerializedName("upcoming_payment_date")
    private String mUpcomingPaymentDate;

    @SerializedName("paymentAmount")
    private double mPaymentAmount;

    public Bill(String _id, BillStatus status, String payee, String nickname, String creation_date, String payment_date, int recurring_date, String upcoming_payment_date, double payment_amount) {
        mId = _id;
        mStatus = status;
        mPayee = payee;
        mNickname = nickname;
        mCreationDate = creation_date;
        mPaymentDate = payment_date;
        mRecurringDate = recurring_date;
        mUpcomingPaymentDate = upcoming_payment_date;
        mPaymentAmount = payment_amount;
    }

    public Bill(Builder builder) {
        mStatus = builder.bStatus;
        mPayee = builder.bPayee;
        mNickname = builder.bNickname;
        mPaymentDate = builder.bPaymentDate;
        mRecurringDate = builder.bRecurringDate;
        mPaymentAmount = builder.bPaymentAmount;
    }

    public String getId() {
        return mId;
    }

    public BillStatus getStatus() {
        return mStatus;
    }

    public String getPayee() {
        return mPayee;
    }

    public String getNickname() {
        return mNickname;
    }

    public String getCreationDate() {
        return mCreationDate;
    }

    public String getPaymentDate() {
        return mPaymentDate;
    }

    public int getRecurringDate() {
        return mRecurringDate;
    }

    public String getUpcomingPaymentDate() {
        return mUpcomingPaymentDate;
    }

    public double getPaymentAmount() {
        return mPaymentAmount;
    }

    public void setId(String _id) {
        mId = _id;
    }

    public void setStatus(BillStatus status) {
        mStatus = status;
    }

    public void setPayee(String mPayee) {
        mPayee = mPayee;
    }

    public void setNickname(String nickname) {
        mNickname = nickname;
    }

    public void setCreationDate(String creation_date) {
        mCreationDate = creation_date;
    }

    public void setPaymentDate(String payment_date) {
        mPaymentDate = payment_date;
    }

    public void setRecurringDate(int recurring_date) {
        mRecurringDate = recurring_date;
    }

    public void setUpcomingPaymentDate(String upcoming_payment_date) {
        mUpcomingPaymentDate = upcoming_payment_date;
    }

    public void setPaymentAmount(double payment_amount) {
        mPaymentAmount = payment_amount;
    }

    @Override
    public String toString() {

        return "Bill{" +
                "mId='" + mId + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mPayee='" + mPayee + '\'' +
                ", mNickname='" + mNickname + '\'' +
                ", mCreationDate='" + mCreationDate + '\'' +
                ", mPaymentDate='" + mPaymentDate + '\'' +
                ", mRecurringDate=" + mRecurringDate +
                ", mUpcomingPaymentDate='" + mUpcomingPaymentDate + '\'' +
                ", mPaymentAmount=" + mPaymentAmount +
                '}';
    }

    public static class Builder{
        private BillStatus bStatus;
        private String bPayee;
        private String bNickname;
        private String bPaymentDate;
        private int bRecurringDate;
        private double bPaymentAmount;

        public Builder(){}

        public Builder(Bill bill) {
            bStatus = bill.getStatus();
            bPayee = bill.getPayee();
            bNickname = bill.getNickname();
            bPaymentDate = bill.getPaymentDate();
            bRecurringDate = bill.getRecurringDate();
            bPaymentAmount = bill.getPaymentAmount();
        }

        public Builder status(BillStatus status){
            bStatus = status;
            return this;
        }

        public Builder payee(String payee){
            bPayee = payee;
            return this;
        }

        public Builder nickname(String nickname){
            bNickname = nickname;
            return this;
        }

        public Builder paymentDate(String payment_date){
            bPaymentDate = payment_date;
            return this;
        }

        public Builder recurringDate(int recurring_date){
            bRecurringDate = recurring_date;
            return this;
        }

        public Builder paymentAmount(double payment_amount){
            bPaymentAmount = payment_amount;
            return this;
        }

        public Bill build(){
            Bill bill = new Bill(this);
            return bill;
        }
    }
}
