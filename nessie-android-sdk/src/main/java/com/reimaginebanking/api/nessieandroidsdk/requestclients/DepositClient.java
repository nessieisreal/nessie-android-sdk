package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.DepositService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Deposit endpoints.
 */
public class DepositClient {

    private DepositService service;

    private String key;

    private static DepositClient INSTANCE;

    private DepositClient(String key, DepositService service) {
        this.key = key;
        this.service = service;
    }

    public static DepositClient getInstance(String key, DepositService service){
        if (INSTANCE == null) {
            INSTANCE = new DepositClient(key, service);
        }
        return INSTANCE;
    }

    public void getDeposits(String accountId, final NessieResultsListener mlistener){
        service.getDeposits(this.key, accountId, new Callback<List<Deposit>>() {
            @Override
            public void success(List<Deposit> transactions, Response response) {
                mlistener.onSuccess(transactions);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getDeposit(String depositId, final NessieResultsListener mlistener){
        service.getDeposit(this.key, depositId, new Callback<Deposit>() {
            @Override
            public void success(Deposit transaction, Response response) {
                mlistener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void createDeposit(String accountId, Deposit deposit, final NessieResultsListener mlistener){
        service.createDeposit(this.key, accountId, deposit, new Callback<PostResponse<Deposit>>() {

            @Override
            public void success(PostResponse<Deposit> requestResponse, Response response) {
                mlistener.onSuccess(requestResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateDeposit(String depositId, Deposit deposit, final NessieResultsListener mlistener){
        service.updateDeposit(this.key, depositId, deposit, new Callback<RequestResponse>() {
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

    public void deleteDeposit(String depositId, final NessieResultsListener mlistener){
        service.deleteDeposit(this.key, depositId, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                requestResponse = new RequestResponse(response.getStatus(), "Deposit Deleted");
                mlistener.onSuccess(requestResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }
}
