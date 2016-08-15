package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.DepositService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Deposit endpoints.
 */
public class DepositClient {

    private DepositService mService;

    private String mKey;

    private static DepositClient INSTANCE;

    private DepositClient(String key, DepositService service) {
        mKey = key;
        mService = service;
    }

    public static DepositClient getInstance(String key, DepositService service){
        if (INSTANCE == null) {
            INSTANCE = new DepositClient(key, service);
        }
        return INSTANCE;
    }

    public void getDeposits(String accountId, final NessieResultsListener listener){
        mService.getDeposits(mKey, accountId, new Callback<List<Deposit>>() {
            @Override
            public void success(List<Deposit> transactions, Response response) {
                listener.onSuccess(transactions);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getDeposit(String depositId, final NessieResultsListener listener){
        mService.getDeposit(mKey, depositId, new Callback<Deposit>() {
            @Override
            public void success(Deposit transaction, Response response) {
                listener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void createDeposit(String accountId, Deposit deposit, final NessieResultsListener listener){
        mService.createDeposit(mKey, accountId, deposit, new Callback<PostResponse<Deposit>>() {

            @Override
            public void success(PostResponse<Deposit> requestResponse, Response response) {
                listener.onSuccess(requestResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateDeposit(String depositId, Deposit deposit, final NessieResultsListener listener){
        mService.updateDeposit(mKey, depositId, deposit, new Callback<PutDeleteResponse>() {
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

    public void deleteDeposit(String depositId, final NessieResultsListener listener){
        mService.deleteDeposit(mKey, depositId, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Deposit Deleted");
                listener.onSuccess(deleteResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
