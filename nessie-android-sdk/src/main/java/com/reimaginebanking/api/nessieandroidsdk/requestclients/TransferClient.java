package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.TransferService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Transfer endpoints.
 */
public class TransferClient {

    private TransferService service;

    private String key;

    private static TransferClient INSTANCE;

    private TransferClient(String key, TransferService service) {
        this.key = key;
        this.service = service;
    }

    public static TransferClient getInstance(String key, TransferService service){
        if (INSTANCE == null) {
            INSTANCE = new TransferClient(key, service);
        }
        return INSTANCE;
    }

    public void getTransfers(String accountId, final NessieResultsListener mlistener){
        service.getTransfers(this.key, accountId, new Callback<List<Transfer>>() {
            @Override
            public void success(List<Transfer> transactions, Response response) {
                mlistener.onSuccess(transactions);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getTransfer(String transferId, final NessieResultsListener mlistener){
        service.getTransfer(this.key, transferId, new Callback<Transfer>() {
            @Override
            public void success(Transfer transaction, Response response) {
                mlistener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void createTransfer(String accountId, Transfer transfer, final NessieResultsListener mlistener){
        service.createTransfer(this.key, accountId, transfer, new Callback<PostResponse<Transfer>>() {

            @Override
            public void success(PostResponse<Transfer> postResponse, Response response) {
                mlistener.onSuccess(postResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateTransfer(String transferId, Transfer transfer, final NessieResultsListener mlistener){
        service.updateTransfer(this.key, transferId, transfer, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse putResponse, Response response) {
                mlistener.onSuccess(putResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void deleteTransfer(String transferId, final NessieResultsListener mlistener){
        service.deleteTransfer(this.key, transferId, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Transfer Deleted");
                mlistener.onSuccess(deleteResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }
}
