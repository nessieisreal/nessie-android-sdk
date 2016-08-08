package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.reimaginebanking.api.nessieandroidsdk.Adapters.BillTypeAdapter;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.NessieService;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * A parent class for all of the Nessie Clients that holds shared logic
 */
public class NessieClient {

    private NessieService service;

    private String key;

    private static NessieClient INSTANCE;

    public final AccountClient ACCOUNT;

    public final AtmClient ATM;

    public final BillClient BILL;

    public final BranchClient BRANCH;

    public final CustomerClient CUSTOMER;

    public final DepositClient DEPOSIT;

    public final EnterpriseClient ENTERPRISE;

    public final MerchantClient MERCHANT;

    public final PurchaseClient PURCHASE;

    public final TransferClient TRANSFER;

    public final WithdrawalClient WITHDRAWAL;


    private NessieClient(String key) {

        Gson gson = new GsonBuilder()
            .registerTypeAdapter(Bill.class, new BillTypeAdapter())
            .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://api.reimaginebanking.com")
            .setConverter(new GsonConverter(gson))
            .build();

        service = restAdapter.create(NessieService.class);
        this.key = key;

        // Instantiate other clients for access through NessieClient
        ACCOUNT = AccountClient.getInstance(this.key, service);
        ATM = AtmClient.getInstance(this.key, service);
        BILL = BillClient.getInstance(this.key, service);
        BRANCH = BranchClient.getInstance(this.key, service);
        CUSTOMER = CustomerClient.getInstance(this.key, service);
        DEPOSIT = DepositClient.getInstance(this.key, service);
        ENTERPRISE = EnterpriseClient.getInstance(this.key, service);
        MERCHANT = MerchantClient.getInstance(this.key, service);
        PURCHASE = PurchaseClient.getInstance(this.key, service);
        TRANSFER = TransferClient.getInstance(this.key, service);
        WITHDRAWAL = WithdrawalClient.getInstance(this.key, service);
    }

    public static NessieClient getInstance(String key){
        if (INSTANCE == null) {
            INSTANCE = new NessieClient(key);
        }

        return INSTANCE;
    }
}
