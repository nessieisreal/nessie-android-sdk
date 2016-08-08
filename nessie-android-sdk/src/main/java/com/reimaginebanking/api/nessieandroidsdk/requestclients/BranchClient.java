package com.reimaginebanking.api.nessieandroidsdk.requestclients;


import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Branch;
import com.reimaginebanking.api.nessieandroidsdk.requestservices.BranchService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A Client singleton object that provides methods for all Branch endpoints.
 */
public class BranchClient {

    private BranchService service;

    private String key;

    private static BranchClient INSTANCE;

    private BranchClient(String key, BranchService service) {
        this.key = key;
        this.service = service;
    }

    public static BranchClient getInstance(String key, BranchService service){
        if (INSTANCE == null) {
            INSTANCE = new BranchClient(key, service);
        }
        return INSTANCE;
    }

    public void getBranches(final NessieResultsListener mlistener){
        service.getBranches(this.key, new Callback<List<Branch>>() {
            public void success(List<Branch> branches, Response response) {
                mlistener.onSuccess(branches);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }

    public void getBranch(String branchID, final NessieResultsListener mlistener){
        service.getBranch(this.key, branchID, new Callback<Branch>() {
            public void success(Branch branch, Response response) {
                mlistener.onSuccess(branch);
            }

            public void failure(RetrofitError error) {
                mlistener.onFailure(new NessieError(error));
            }
        });
    }
}
