package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieException;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
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
                mlistener.onSuccess(transactions, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getTransfer(String transferId, final NessieResultsListener mlistener){
        service.getTransfer(this.key, transferId, new Callback<Transfer>() {
            @Override
            public void success(Transfer transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createTransfer(String accountId, Transfer transfer, final NessieResultsListener mlistener){
        service.createTransfer(this.key, accountId, transfer, new Callback<RequestResponse>() {

            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void updateTransfer(String transferId, Transfer transfer, final NessieResultsListener mlistener){
        service.updateTransfer(this.key, transferId, transfer, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void deleteTransfer(String transferId, final NessieResultsListener mlistener){
        service.deleteTransfer(this.key, transferId, new Callback<RequestResponse>() {
            @Override
            public void success(RequestResponse requestResponse, Response response) {
                mlistener.onSuccess(requestResponse, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }
}
