package com.reimaginebanking.api.nessieandroidsdk.constants;

/**
 * The types of accounts related to a transfer
 *
 * payer - the account that is paying in the transfer
 * payee - the account that is receiving the funds in the transfer
 */
public enum TransferAccountType {
    PAYER("payer"),
    PAYEE("payee");

    private final String type;

    private TransferAccountType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
