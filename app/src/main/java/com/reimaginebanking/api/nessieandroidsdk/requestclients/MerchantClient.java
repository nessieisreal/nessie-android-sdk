package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieException;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.NessieService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Merchant endpoints.
 */
public class MerchantClient {

    private NessieService service;

    private String key;

    private static MerchantClient INSTANCE;

    private MerchantClient(String key, NessieService service) {
        this.key = key;
        this.service = service;
    }

    public static MerchantClient getInstance(String key, NessieService service){
        if (INSTANCE == null) {
            INSTANCE = new MerchantClient(key, service);
        }
        return INSTANCE;
    }

    public void getMerchants(final NessieResultsListener mlistener){
        service.getMerchants(this.key, new Callback<List<Merchant>>() {
            @Override
            public void success(List<Merchant> merchants, Response response) {
                mlistener.onSuccess(merchants, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getMerchant(String merchantId, final NessieResultsListener mlistener){
        service.getMerchant(this.key, merchantId, new Callback<Merchant>() {
            @Override
            public void success(Merchant merchant, Response response) {
                mlistener.onSuccess(merchant, null);
            }

            @Override
            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void createMerchant(Merchant merchant, final NessieResultsListener mlistener){
        service.createMerchant(this.key, merchant, new Callback<RequestResponse>() {

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

    public void updateMerchant(String merchantId, Merchant updatedMerchant, final NessieResultsListener mlistener){
        service.updateMerchant(this.key, merchantId, updatedMerchant, new Callback<RequestResponse>() {
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
