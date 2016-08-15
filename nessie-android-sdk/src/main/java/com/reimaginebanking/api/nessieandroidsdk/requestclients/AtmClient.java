package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.ATM;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.AtmService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all ATM endpoints.
 */
public class AtmClient {

    private AtmService mService;

    private String mKey;

    private static AtmClient INSTANCE;

    private AtmClient(String key, AtmService service) {
        mKey = key;
        mService = service;
    }

    public static AtmClient getInstance(String key, AtmService service){
        if (INSTANCE == null) {
            INSTANCE = new AtmClient(key, service);
        }
        return INSTANCE;
    }

    public void getATMs(final NessieResultsListener listener){
        mService.getATMs(mKey, new Callback<List<ATM>>() {
            public void success(List<ATM> atms, Response response) {
                listener.onSuccess(atms);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getATM(String atmID, final NessieResultsListener listener){
        mService.getATM(mKey, atmID, new Callback<ATM>() {
            public void success(ATM atm, Response response) {
                listener.onSuccess(atm);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
