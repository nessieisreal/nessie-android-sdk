package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.constants.AccountType;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.AccountService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Account endpoints.
 */
public class AccountClient {

    private AccountService mService;

    private String mKey;

    private static AccountClient INSTANCE;

    private AccountClient(String key, AccountService service) {
        mKey = key;
        mService = service;
    }

    public static AccountClient getInstance(String key, AccountService service){
        if (INSTANCE == null) {
            INSTANCE = new AccountClient(key, service);
        }
        return INSTANCE;
    }

    /**
     * Retrieve all accounts.
     *
     * @param listener The listener object which will implement the callback interface
     */
    public void getAccounts(final NessieResultsListener listener){
        getAccounts(null, listener);
    }

    /**
     * Retrieve all accounts for a specific {@link AccountType}.
     *
     * @param type The type of account to retrieve
     * @param listener The listener object which will implement the callback interface
     */
    public void getAccounts(AccountType type, final NessieResultsListener listener){
        mService.getAccounts(mKey, type, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                listener.onSuccess(accounts);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve a single account.
     *
     * @param accountID The id of the account to retrieve
     * @param listener The listener object which will implement the callback interface
     */
    public void getAccount(String accountID, final NessieResultsListener listener){
        mService.getAccount(mKey, accountID, new Callback<Account>() {
            public void success(Account account, Response response) {
                listener.onSuccess(account);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve all accounts for a specific customer.
     *
     * @param customerID The id of the customer to retrieve accounts for
     * @param listener The listener object which will implement the callback interface
     */
    public void getCustomerAccounts(String customerID, final NessieResultsListener listener){
        mService.getCustomerAccounts(mKey, customerID, new Callback<List<Account>>() {
            public void success(List<Account> accounts, Response response) {
                listener.onSuccess(accounts);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }


    /**
     * Create an account.
     *
     * @param customerID The id of the customer who will own this account
     * @param newAccount The account object to create
     * @param listener The listener object which will implement the callback interface
     */
    public void createAccount(String customerID, Account newAccount, final NessieResultsListener listener){
        mService.createAccount(mKey, customerID, newAccount, new Callback<PostResponse<Account>>() {

            @Override
            public void success(PostResponse<Account> postResponse, Response response) {
                listener.onSuccess(postResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Update an account.
     *
     * @param accountId The id of the account to update
     * @param updatedAccount The account object which includes the updates
     * @param listener The listener object which will implement the callback interface
     */
    public void updateAccount(String accountId, Account updatedAccount, final NessieResultsListener listener){
        mService.updateAccount(mKey, accountId, updatedAccount, new Callback<PutDeleteResponse>() {
            public void success(PutDeleteResponse putResponse, Response response) {
                listener.onSuccess(putResponse);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Delete an account.
     *
     * @param accountID The id of the account to delete
     * @param listener The listener object which will implement the callback interface
     */
    public void deleteAccount(String accountID, final NessieResultsListener listener){
        mService.deleteAccount(mKey, accountID, new Callback<PutDeleteResponse>() {
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Account Deleted");
                listener.onSuccess(deleteResponse);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

}
