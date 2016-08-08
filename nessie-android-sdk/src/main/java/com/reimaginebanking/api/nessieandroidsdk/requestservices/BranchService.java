package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.Branch;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Branch endpoints
 */
public interface BranchService {
    @GET("/branches")
    void getBranches(@Query("key") String key, Callback<List<Branch>> cb);

    @GET("/branches/{id}")
    void getBranch(@Query("key") String key, @Path("id") String id, Callback<Branch> cb);
}
