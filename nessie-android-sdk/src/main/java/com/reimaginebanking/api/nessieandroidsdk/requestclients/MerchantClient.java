package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.MerchantService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Merchant endpoints.
 */
public class MerchantClient {

    private MerchantService mService;

    private String mKey;

    private static MerchantClient INSTANCE;

    private MerchantClient(String key, MerchantService service) {
        mKey = key;
        mService = service;
    }

    public static MerchantClient getInstance(String key, MerchantService service){
        if (INSTANCE == null) {
            INSTANCE = new MerchantClient(key, service);
        }
        return INSTANCE;
    }

    /**
     * Retrieve all merchants within a specified area.
     *
     * @param latitude The latitude line for the merchant search
     * @param longitude The longitude line for merchant search
     * @param radius The radius from the lat/lng point to search within
     * @param listener The listener object which will implement the callback interface
     */
    public void getMerchants(Float latitude, Float longitude, Float radius, final NessieResultsListener listener){
        mService.getMerchants(mKey, latitude, longitude, radius, new Callback<List<Merchant>>() {
            @Override
            public void success(List<Merchant> merchants, Response response) {
                listener.onSuccess(merchants);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Retrieves a single merchant.
     *
     * @param merchantId The id of the merchant to retrieve
     * @param listener The listener object which will implement the callback interface
     */
    public void getMerchant(String merchantId, final NessieResultsListener listener){
        mService.getMerchant(mKey, merchantId, new Callback<Merchant>() {
            @Override
            public void success(Merchant merchant, Response response) {
                listener.onSuccess(merchant);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Create a merchant.
     *
     * @param merchant The merchant object to create
     * @param listener The listener object which will implement the callback interface
     */
    public void createMerchant(Merchant merchant, final NessieResultsListener listener){
        mService.createMerchant(mKey, merchant, new Callback<PostResponse<Merchant>>() {

            @Override
            public void success(PostResponse<Merchant> postResponse, Response response) {
                listener.onSuccess(postResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    /**
     * Update a merchant.
     *
     * @param merchantId The id of the merchant to update
     * @param updatedMerchant The merchant object which includes the updates
     * @param listener The listener object which will implement the callback interface
     */
    public void updateMerchant(String merchantId, Merchant updatedMerchant, final NessieResultsListener listener){
        mService.updateMerchant(mKey, merchantId, updatedMerchant, new Callback<PutDeleteResponse>() {
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
}
