package com.reimaginebanking.api.nessieandroidsdk.requestclients;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Purchase;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.PurchaseService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Purchase endpoints.
 */
public class PurchaseClient {

    private PurchaseService service;

    private String key;

    private static PurchaseClient INSTANCE;

    private PurchaseClient(String key, PurchaseService service) {
        this.key = key;
        this.service = service;
    }

    public static PurchaseClient getInstance(String key, PurchaseService service){
        if (INSTANCE == null) {
            INSTANCE = new PurchaseClient(key, service);
        }
        return INSTANCE;
    }

    public void getPurchasesByAccount(String accountId, final NessieResultsListener mlistener){
        service.getPurchasesByAccount(key, accountId, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> transactions, Response response) {
                mlistener.onSuccess(transactions);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getPurchasesByMerchantAndAccount(String merchantId, String accountId, final NessieResultsListener mListener) {
        service.getPurchasesByMerchantAndAccount(key, merchantId, accountId, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> purchases, Response response) {
                mListener.onSuccess(purchases);
            }

            @Override
            public void failure(RetrofitError error) {
                mListener.onFailure(new NessieError(error));
            }
        });
    }

    public void getPurchasesByMerchant(String merchantId, final NessieResultsListener mListener) {
        service.getPurchasesByMerchant(key, merchantId, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> purchases, Response response) {
                mListener.onSuccess(purchases);
            }

            @Override
            public void failure(RetrofitError error) {
                mListener.onFailure(new NessieError(error));
            }
        });
    }

    public void getPurchase(String purchaseId, final NessieResultsListener mlistener){
        service.getPurchase(key, purchaseId, new Callback<Purchase>() {
            @Override
            public void success(Purchase transaction, Response response) {
                mlistener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void createPurchase(String accountId, Purchase purchase, final NessieResultsListener mlistener){
        service.createPurchase(key, accountId, purchase, new Callback<PostResponse<Purchase>>() {

            @Override
            public void success(PostResponse<Purchase> postResponse, Response response) {
                mlistener.onSuccess(postResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void updatePurchase(String purchaseId, Purchase purchase, final NessieResultsListener mlistener){
        service.updatePurchase(key, purchaseId, purchase, new Callback<PutDeleteResponse>() {
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

    public void deletePurchase(String merchantId, final NessieResultsListener mlistener){
        service.deletePurchase(key, merchantId, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Purchase Deleted");
                mlistener.onSuccess(deleteResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }
}
