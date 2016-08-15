package com.reimaginebanking.api.nessieandroidsdk.constants;

import com.google.gson.annotations.SerializedName;

/**
 * The different types of transaction mediums that are possible,
 *
 * Balance - transaction involving the monetary balance in an account
 * Rewards - transaction involving the rewards points in an account
 */
public enum TransactionMedium {
    @SerializedName("balance")
    BALANCE("balance"),
    @SerializedName("rewards")
    REWARDS("rewards");

    private final String medium;

    private TransactionMedium(String medium){
        this.medium = medium;
    }

    @Override
    public String toString(){
        return medium;
    }
}
