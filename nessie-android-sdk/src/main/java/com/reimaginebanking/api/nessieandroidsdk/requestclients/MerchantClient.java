package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
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

    private MerchantService service;

    private String key;

    private static MerchantClient INSTANCE;

    private MerchantClient(String key, MerchantService service) {
        this.key = key;
        this.service = service;
    }

    public static MerchantClient getInstance(String key, MerchantService service){
        if (INSTANCE == null) {
            INSTANCE = new MerchantClient(key, service);
        }
        return INSTANCE;
    }

    public void getMerchants(final NessieResultsListener mlistener){
        service.getMerchants(this.key, new Callback<List<Merchant>>() {
            @Override
            public void success(List<Merchant> merchants, Response response) {
                mlistener.onSuccess(merchants);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getMerchant(String merchantId, final NessieResultsListener mlistener){
        service.getMerchant(this.key, merchantId, new Callback<Merchant>() {
            @Override
            public void success(Merchant merchant, Response response) {
                mlistener.onSuccess(merchant);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void createMerchant(Merchant merchant, final NessieResultsListener mlistener){
        service.createMerchant(this.key, merchant, new Callback<PutDeleteResponse>() {

            @Override
            public void success(PutDeleteResponse putDeleteResponse, Response response) {
                mlistener.onSuccess(putDeleteResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void updateMerchant(String merchantId, Merchant updatedMerchant, final NessieResultsListener mlistener){
        service.updateMerchant(this.key, merchantId, updatedMerchant, new Callback<PutDeleteResponse>() {
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
}
