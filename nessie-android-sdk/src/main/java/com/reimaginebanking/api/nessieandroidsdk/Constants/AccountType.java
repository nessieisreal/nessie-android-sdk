package com.reimaginebanking.api.nessieandroidsdk.constants;

import com.google.gson.annotations.SerializedName;

/**
 * An object representing the different possible types of accounts
 *
 * Credit Card - an account representing a credit card
 * Savings - a bank account representing a savings account
 * Checking - a bank account representing a checking account
 */
public enum AccountType {
    @SerializedName("Credit Card")
    CREDITCARD("Credit Card"),
    @SerializedName("Savings")
    SAVINGS("Savings"),
    @SerializedName("Checking")
    CHECKING("Checking");

    private final String type;
    private AccountType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }


}
