package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
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

    private WithdrawalService service;

    private String key;

    private static WithdrawalClient INSTANCE;

    private WithdrawalClient(String key, WithdrawalService service) {
        this.key = key;
        this.service = service;
    }

    public static WithdrawalClient getInstance(String key, WithdrawalService service){
        if (INSTANCE == null) {
            INSTANCE = new WithdrawalClient(key, service);
        }
        return INSTANCE;
    }

    public void getWithdrawals(String accountId, final NessieResultsListener mlistener){
        service.getWithdrawals(this.key, accountId, new Callback<List<Withdrawal>>() {
            @Override
            public void success(List<Withdrawal> transactions, Response response) {
                mlistener.onSuccess(transactions);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getWithdrawal(String withdrawalId, final NessieResultsListener mlistener){
        service.getWithdrawal(this.key, withdrawalId, new Callback<Withdrawal>() {
            @Override
            public void success(Withdrawal transaction, Response response) {
                mlistener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void createWithdrawal(String accountId, Withdrawal withdrawal, final NessieResultsListener mlistener){
        service.createWithdrawal(this.key, accountId, withdrawal, new Callback<PostResponse<Withdrawal>>() {

            @Override
            public void success(PostResponse<Withdrawal> requestResponse, Response response) {
                mlistener.onSuccess(requestResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateWithdrawal(String withdrawalId, Withdrawal withdrawal, final NessieResultsListener mlistener){
        service.updateWithdrawal(this.key, withdrawalId, withdrawal, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void deleteWithdrawal(String withdrawalId, final NessieResultsListener mlistener){
        service.deleteWithdrawal(this.key, withdrawalId, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                requestResponse = new RequestResponse(response.getStatus(), "Withdrawal Deleted");
                mlistener.onSuccess(requestResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }
}
