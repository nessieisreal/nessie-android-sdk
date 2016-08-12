package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.AccountService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Account endpoints.
 */
public class AccountClient {

    private AccountService service;

    private String key;

    private static AccountClient INSTANCE;

    private AccountClient(String key, AccountService service) {
        this.key = key;
        this.service = service;
    }

    public static AccountClient getInstance(String key, AccountService service){
        if (INSTANCE == null) {
            INSTANCE = new AccountClient(key, service);
        }
        return INSTANCE;
    }

    public void getAccounts(final NessieResultsListener mlistener){
        service.getAccounts(this.key, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getAccount(String accountID, final NessieResultsListener mlistener){
        service.getAccount(this.key, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                mlistener.onSuccess(account);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getCustomerAccounts(String customerID, final NessieResultsListener mlistener){
        service.getCustomerAccounts(this.key, customerID, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                mlistener.onSuccess(accounts);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }


    public void createAccount(String customerID, Account newAccount, final NessieResultsListener mlistener){
        service.createAccount(this.key, customerID, newAccount, new Callback<PostResponse<Account>>() {
            public void success(PostResponse<Account> requestResponse, Response response) {
                mlistener.onSuccess(requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateAccount(String accountId, Account updatedAccount, final NessieResultsListener mlistener){
        service.updateAccount(this.key, accountId, updatedAccount, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void deleteAccount(String accountID, final NessieResultsListener mlistener){
        service.deleteAccount(this.key, accountID, new Callback<RequestResponse>() {
            public void success(RequestResponse requestResponse, Response response) {
                requestResponse = new RequestResponse(response.getStatus(), "Account Deleted");
                mlistener.onSuccess(requestResponse);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

}
