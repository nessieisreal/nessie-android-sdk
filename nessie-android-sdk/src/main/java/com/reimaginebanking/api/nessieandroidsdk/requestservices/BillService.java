package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.Bill;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Bill endpoints
 */
public interface BillService {
    @GET("/accounts/{account_id}/bills")
    void getBillsByAccount(@Query("key") String key, @Path("account_id") String id, Callback<List<Bill>> cb);

    @GET("/bills/{bill_id}")
    void getBill(@Query("key") String key, @Path("bill_id") String bill_id, Callback<Bill> cb);

    @GET("/customers/{id}/bills")
    void getBillsByCustomer(@Query("key") String key, @Path("id") String id, Callback<List<Bill>> cb);

    @POST("/accounts/{id}/bills")
    void createBill(@Query("key") String key, @Path("id") String id, @Body Bill bill, Callback<PostResponse<Bill>> cb);

    @Headers("Content-Type: application/json")
    @PUT("/bills/{bill_id}")
    void updateBill(@Query("key") String key, @Path("bill_id") String bill_id, @Body Bill bill, Callback<PutDeleteResponse> cb);

    @DELETE("/bills/{bill_id}")
    void deleteBill(@Query("key") String key, @Path("bill_id") String bill_id, Callback<PutDeleteResponse> cb);
}
