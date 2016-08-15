package com.reimaginebanking.api.nessieandroidsdk.constants;

import com.google.gson.annotations.SerializedName;

/**
 * The different statuses that a Bill can be in
 *
 * Pending - the bill payment has been initiated and is waiting execution
 * Cancelled - the bill payment has been cancelled
 * Complete - the bill payment has been executed
 * Recurring - the bill payment is a recurring payment
 */
public enum BillStatus {
    @SerializedName("pending")
    PENDING("pending"),
    @SerializedName("cancelled")
    CANCELLED("canceled"),
    @SerializedName("completed")
    COMPLETED("completed"),
    @SerializedName("recurring")
    RECURRING("recurring");

    private final String status;

    private BillStatus(final String status){
        this.status = status;
    }

    @Override
    public String toString(){
        return status;
    }
}
