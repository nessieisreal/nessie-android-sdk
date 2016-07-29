package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieException;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.NessieService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Account endpoints.
 */
public class AccountClient {

    private NessieService service;

    private String key;

    private static AccountClient INSTANCE;

    private AccountClient(String key, NessieService service) {
        this.key = key;
        this.service = service;
    }

    public static AccountClient getInstance(String key, NessieService service){
        if (INSTANCE == null) {
            INSTANCE = new AccountClient(key, service);
        }
        return INSTANCE;
    }

    public void getAccounts(final NessieResultsListener mlistener){
        service.getAccounts(this.key, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getAccount(String accountID, final NessieResultsListener mlistener){
        service.getAccount(this.key, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                mlistener.onSuccess(account, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getCustomerAccounts(String customerID, final NessieResultsListener mlistener){
        service.getCustomerAccounts(this.key, customerID, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }


    public void createAccount(String customerID, Account newAccount, final NessieResultsListener mlistener){
        service.createAccount(this.key, customerID, newAccount, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateAccount(String accountId, Account updatedAccount, final NessieResultsListener mlistener){
        service.updateAccount(this.key, accountId, updatedAccount, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void deleteAccount(String accountID, final NessieResultsListener mlistener){
        service.deleteAccount(this.key, accountID, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                requestResponse = new RequestResponse(response.getStatus(), "Account Deleted");
                mlistener.onSuccess(requestResponse, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

}
