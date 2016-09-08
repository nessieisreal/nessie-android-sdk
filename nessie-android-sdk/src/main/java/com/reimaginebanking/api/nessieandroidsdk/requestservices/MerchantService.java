package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.PaginatedResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PostResponse;
import com.reimaginebanking.api.nessieandroidsdk.models.PutDeleteResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Merchant endpoints
 */
public interface MerchantService {

    @GET("/{paginationRequest}")
    void getMerchantsFromPagination(@Path(encode = false, value = "paginationRequest") String paginationRequest,
        Callback<PaginatedResponse<Merchant>> cb);

    @GET("/merchants")
    void getMerchants(@Query("key") String key, @Query("lat") Float latitude, @Query("lng") Float longitude, @Query("rad") Float radius,
        @Query("page") Integer page, Callback<PaginatedResponse<Merchant>> cb);

    @GET("/merchants/{id}")
    void getMerchant(@Query("key") String key, @Path("id") String merchantId, Callback<Merchant> cb);

    @POST("/merchants")
    void createMerchant(@Query("key") String key, @Body Merchant merchant, Callback<PostResponse<Merchant>> cb);

    @PUT("/merchants/{id}")
    void updateMerchant(@Query("key") String key, @Path("id") String merchantId, @Body Merchant merchant, Callback<PutDeleteResponse> cb);
}
