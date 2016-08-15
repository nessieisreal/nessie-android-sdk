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

    private PurchaseService mService;

    private String mKey;

    private static PurchaseClient INSTANCE;

    private PurchaseClient(String key, PurchaseService service) {
        mKey = key;
        mService = service;
    }

    public static PurchaseClient getInstance(String key, PurchaseService service){
        if (INSTANCE == null) {
            INSTANCE = new PurchaseClient(key, service);
        }
        return INSTANCE;
    }

    public void getPurchasesByAccount(String accountId, final NessieResultsListener listener){
        mService.getPurchasesByAccount(mKey, accountId, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> transactions, Response response) {
                listener.onSuccess(transactions);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getPurchasesByMerchantAndAccount(String merchantId, String accountId, final NessieResultsListener listener) {
        mService.getPurchasesByMerchantAndAccount(mKey, merchantId, accountId, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> purchases, Response response) {
                listener.onSuccess(purchases);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getPurchasesByMerchant(String merchantId, final NessieResultsListener listener) {
        mService.getPurchasesByMerchant(mKey, merchantId, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> purchases, Response response) {
                listener.onSuccess(purchases);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getPurchase(String purchaseId, final NessieResultsListener listener){
        mService.getPurchase(mKey, purchaseId, new Callback<Purchase>() {
            @Override
            public void success(Purchase transaction, Response response) {
                listener.onSuccess(transaction);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void createPurchase(String accountId, Purchase purchase, final NessieResultsListener listener){
        mService.createPurchase(mKey, accountId, purchase, new Callback<PostResponse<Purchase>>() {

            @Override
            public void success(PostResponse<Purchase> postResponse, Response response) {
                listener.onSuccess(postResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void updatePurchase(String purchaseId, Purchase purchase, final NessieResultsListener listener){
        mService.updatePurchase(mKey, purchaseId, purchase, new Callback<PutDeleteResponse>() {
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

    public void deletePurchase(String merchantId, final NessieResultsListener listener){
        mService.deletePurchase(mKey, merchantId, new Callback<PutDeleteResponse>() {
            @Override
            public void success(PutDeleteResponse deleteResponse, Response response) {
                deleteResponse = new PutDeleteResponse(response.getStatus(), "Purchase Deleted");
                listener.onSuccess(deleteResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
