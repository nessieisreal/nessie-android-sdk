package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieException;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Branch;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.NessieService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Branch endpoints.
 */
public class BranchClient {

    private NessieService service;

    private String key;

    private static BranchClient INSTANCE;

    private BranchClient(String key, NessieService service) {
        this.key = key;
        this.service = service;
    }

    public static BranchClient getInstance(String key, NessieService service){
        if (INSTANCE == null) {
            INSTANCE = new BranchClient(key, service);
        }
        return INSTANCE;
    }

    public void getBranches(final NessieResultsListener mlistener){
        service.getBranches(this.key, new Callback<List<Branch>>() {
            public void success(List<Branch> branches, Response response) {
                mlistener.onSuccess(branches, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }

    public void getBranch(String branchID, final NessieResultsListener mlistener){
        service.getBranch(this.key, branchID, new Callback<Branch>() {
            public void success(Branch branch, Response response) {
                mlistener.onSuccess(branch, null);
            }

            public void failure(RetrofitError error) {
                mlistener.onSuccess(null, new NessieException(error));
            }
        });
    }
}
