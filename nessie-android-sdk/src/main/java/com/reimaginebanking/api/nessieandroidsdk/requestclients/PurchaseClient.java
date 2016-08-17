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

    /**
     * Retrieve purchases for a specific account.
     *
     * @param accountId The id of the account to retrieve purchases for
     * @param listener The listener object which will implement the callback interface
     */
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

    /**
     * Retrieve purchases for a specific account at a specific merchant.
     *
     * @param merchantId The id of the merchant the purchases were made at
     * @param accountId The id of the account to retrieve purchases for
     * @param listener The listener object which will implement the callback interface
     */
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

    /**
     * Retrieve purchases made at a specific merchant.
     *
     * @param merchantId The id of the merchant the purchases were made at
     * @param listener The listener object which will implement the callback interface
     */
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

    /**
     * Retrieve a single purchase.
     *
     * @param purchaseId The id of the purchase to retrieve
     * @param listener The listener object which will implement the callback interface
     */
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

    /**
     * Create a purchase.
     *
     * @param accountId the id of the account that made the purchase
     * @param purchase The purchase object to create
     * @param listener The listener object which will implement the callback interface
     */
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

    /**
     * Update a purchase. A transfer can only be updated before it is executed.
     *
     * @param purchaseId The id of the purchase to update
     * @param purchase The purchase object which includes the updates
     * @param listener The listener object which will implement the callback interface
     */
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

    /**
     * Delete a purchase.  A purchase can only be deleted before it is executed.
     *
     * @param purchaseId The id of the purchase to delet
     * @param listener The listener object which will implement the callback interface
     */
    public void deletePurchase(String purchaseId, final NessieResultsListener listener){
        mService.deletePurchase(mKey, purchaseId, new Callback<PutDeleteResponse>() {
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
