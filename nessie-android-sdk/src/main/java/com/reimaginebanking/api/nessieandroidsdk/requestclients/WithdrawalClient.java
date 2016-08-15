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
