package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.Deposit;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Deposit endpoints
 */
public interface DepositService {
    @GET("/accounts/{accountId}/deposits")
    void getDeposits(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Deposit>> cb);

    @GET("/deposits/{depositId}")
    void getDeposit(@Query("key") String key, @Path("depositId") String depositId, Callback<Deposit> cb);

    //working
    @POST("/accounts/{accountId}/deposits")
    void createDeposit(@Query("key") String key, @Path("accountId") String accountId, @Body Deposit deposit, Callback<PostResponse<Deposit>>
        cb);

    @PUT("/deposits/{depositId}")
    void updateDeposit(@Query("key") String key, @Path("depositId") String depositId, @Body Deposit deposit, Callback<PutDeleteResponse> cb);

    @DELETE("/deposits/{depositId}")
    void deleteDeposit(@Query("key") String key, @Path("depositId") String depositId, Callback<PutDeleteResponse> cb);
}
