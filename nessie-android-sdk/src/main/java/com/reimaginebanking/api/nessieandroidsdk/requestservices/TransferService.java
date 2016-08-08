package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.RequestResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Transfer;

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
 * Transfer endpoints
 */
public interface TransferService {
    @GET("/accounts/{accountId}/transfers")
    void getTransfers(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Transfer>> cb);

    @GET("/transfers/{transferId}")
    void getTransfer(@Query("key") String key, @Path("transferId") String transferId, Callback<Transfer> cb);

    @POST("/accounts/{accountId}/transfers")
    void createTransfer(@Query("key") String key, @Path("accountId") String accountId, @Body Transfer transfer,
        Callback<RequestResponse> cb);

    @PUT("/transfers/{transferId}")
    void updateTransfer(@Query("key") String key, @Path("transferId") String transferId, @Body Transfer transfer,
        Callback<RequestResponse> cb);

    @DELETE("/transfers/{transferId}")
    void deleteTransfer(@Query("key") String key, @Path("transferId") String transferId, Callback<RequestResponse> cb);
}
