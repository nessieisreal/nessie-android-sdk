package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieException;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Purchase;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.NessieService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Purchase endpoints.
 */
public class PurchaseClient {

    private NessieService service;

    private String key;

    private static PurchaseClient INSTANCE;

    private PurchaseClient(String key, NessieService service) {
        this.key = key;
        this.service = service;
    }

    public static PurchaseClient getInstance(String key, NessieService service){
        if (INSTANCE == null) {
            INSTANCE = new PurchaseClient(key, service);
        }
        return INSTANCE;
    }

    public void getPurchases(String accountId, final NessieResultsListener mlistener){
        service.getPurchases(this.key, accountId, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> transactions, Response response) {
                mlistener.onSuccess(transactions, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getPurchase(String purchaseId, final NessieResultsListener mlistener){
        service.getPurchase(this.key, purchaseId, new Callback<Purchase>() {
            @Override
            public void success(Purchase transaction, Response response) {
                mlistener.onSuccess(transaction, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createPurchase(String accountId, Purchase purchase, final NessieResultsListener mlistener){
        service.createPurchase(this.key, accountId, purchase, new Callback<RequestResponse>() {

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

    public void updatePurchase(String purchaseId, Purchase purchase, final NessieResultsListener mlistener){
        service.updatePurchase(this.key, purchaseId, purchase, new Callback<RequestResponse>() {
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

    public void deletePurchase(String merchantId, final NessieResultsListener mlistener){
        service.deletePurchase(this.key, merchantId, new Callback<RequestResponse>() {
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
