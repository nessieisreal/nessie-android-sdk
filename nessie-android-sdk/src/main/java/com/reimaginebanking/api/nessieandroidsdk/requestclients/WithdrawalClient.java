package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Withdrawal;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.WithdrawalService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Withdrawal endpoints.
 */
public class WithdrawalClient {

    private WithdrawalService mService;

    private String mKey;

    private static WithdrawalClient INSTANCE;

    private WithdrawalClient(String key, WithdrawalService service) {
        mKey = key;
        mService = service;
    }

    public static WithdrawalClient getInstance(String key, WithdrawalService service){
        if (INSTANCE == null) {
            INSTANCE = new WithdrawalClient(key, service);
        }
        return INSTANCE;
    }

    /**
     * Retrieve withdrawals for a specific account.
     *
     * @param accountId The id of the account to retrieve withdrawals for
     * @param listener The listener object which will implement the callback interface
     */
    public void getWithdrawals(String accountId, final NessieResultsListener listener){
        mService.getWithdrawals(mKey, accountId, new Callback<List<Withdrawal>>() {
            @Override
            public void success(List<Withdrawal> transactions, Response response) {
                listener.onSuccess(transactions);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieve a specific withdrawal.
     *
     * @param withdrawalId The id of the withdrawal to retrieve
     * @param listener The listener object which will implement the callback interface
     */
    public void getWithdrawal(String withdrawalId, final NessieResultsListener listener){
        mService.getWithdrawal(mKey, withdrawalId, new Callback<Withdrawal>() {
            @Override
            public void success(Withdrawal transaction, Response response) {
                listener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Create a withdrawal.
     *
     * @param accountId The id of the account the withdrawal will go into
     * @param withdrawal The withdrawal object to create
     * @param listener The listener object which will implement the callback interface
     */
    public void createWithdrawal(String accountId, Withdrawal withdrawal, final NessieResultsListener listener){
        mService.createWithdrawal(mKey, accountId, withdrawal, new Callback<PostResponse<Withdrawal>>() {

            @Override
            public void success(PostResponse<Withdrawal> requestResponse, Response response) {
                listener.onSuccess(requestResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Update a withdrawal. A withdrawal can only be updated before it is executed.
     *
     * @param withdrawalId The id of the withdrawal to update
     * @param withdrawal The withdrawal object which includes the updates
     * @param listener The listener object which will implement the callback interface
     */
    public void updateWithdrawal(String withdrawalId, Withdrawal withdrawal, final NessieResultsListener listener){
        mService.updateWithdrawal(mKey, withdrawalId, withdrawal, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse putResponse, Response response) {
                listener.onSuccess(putResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Delete a withdrawal. A withdrawal can only be deleted before it is executed.
     *
     * @param withdrawalId The id of the withdrawal to delete
     * @param listener The listener object which will implement the callback interface
     */
    public void deleteWithdrawal(String withdrawalId, final NessieResultsListener listener){
        mService.deleteWithdrawal(mKey, withdrawalId, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Withdrawal Deleted");
                listener.onSuccess(deleteResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
