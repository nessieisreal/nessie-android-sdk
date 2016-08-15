package com.reimaginebanking.api.nessieandroidsdk.constants;

/**
 * The types of transactions that are possible
 *
 * P2P - A transaction between two accounts
 * Deposit - A transaction which transfers an amount of type {@link TransactionMedium} into an account
 * Withdrawal - A transaction which transfers an amount of type {@link TransactionMedium} out of an account
 */
public enum TransactionType {
    P2P("p2p"),
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal");

    private final String type;

    private TransactionType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
