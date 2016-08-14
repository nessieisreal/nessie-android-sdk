package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.Purchase;
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
 * Purchase endpoints
 */
public interface PurchaseService {
    @GET("/accounts/{accountId}/purchases")
    void getPurchasesByAccount(@Query("key") String key, @Path("accountId") String accountId, Callback<List<Purchase>> cb);

    @GET("/merchants/{merchantId}/accounts/{accountId}/purchases")
    void getPurchasesByMerchantAndAccount(@Query("key") String key, @Path("merchantId") String merchantId, @Path("accountId") String
        accountId, Callback<List<Purchase>> cb);

    @GET("/merchants/{merchantId}/purchases")
    void getPurchasesByMerchant(@Query("key") String key, @Path("merchantId") String merchantId, Callback<List<Purchase>> cb);

    @GET("/purchases/{purchaseId}")
    void getPurchase(@Query("key") String key, @Path("purchaseId") String purchaseId, Callback<Purchase> cb);

    @POST("/accounts/{accountId}/purchases")
    void createPurchase(@Query("key") String key, @Path("accountId") String accountId, @Body Purchase purchase,
        Callback<PostResponse<Purchase>> cb);

    @PUT("/purchases/{purchaseId}")
    void updatePurchase(@Query("key") String key, @Path("purchaseId") String purchaseId, @Body Purchase purchase,
        Callback<PutDeleteResponse> cb);

    @DELETE("/purchases/{purchaseId}")
    void deletePurchase(@Query("key") String key, @Path("purchaseId") String purchaseId, Callback<PutDeleteResponse> cb);
}
