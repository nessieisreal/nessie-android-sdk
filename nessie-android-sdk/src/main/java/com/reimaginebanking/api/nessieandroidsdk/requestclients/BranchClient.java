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

    private BranchService mService;

    private String mKey;

    private static BranchClient INSTANCE;

    private BranchClient(String key, BranchService service) {
        mKey = key;
        mService = service;
    }

    public static BranchClient getInstance(String key, BranchService service){
        if (INSTANCE == null) {
            INSTANCE = new BranchClient(key, service);
        }
        return INSTANCE;
    }

    public void getBranches(final NessieResultsListener listener){
        mService.getBranches(mKey, new Callback<List<Branch>>() {
            public void success(List<Branch> branches, Response response) {
                listener.onSuccess(branches);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }

    public void getBranch(String branchID, final NessieResultsListener listener){
        mService.getBranch(mKey, branchID, new Callback<Branch>() {
            public void success(Branch branch, Response response) {
                listener.onSuccess(branch);
            }

            public void failure(RetrofitError error) {
                listener.onFailure(new NessieError(error));
            }
        });
    }
}
