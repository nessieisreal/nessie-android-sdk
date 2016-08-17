package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.ATM;
import com.reimaginebanking.api.nessieandroidsdk.models.PaginatedResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * ATM endpoints
 */
public interface AtmService {

    @GET("/{paginationRequest}")
    void getATMsFromPaginationUrl(@Path(encode = false, value = "paginationRequest") String paginationRequest,
        Callback<PaginatedResponse<ATM>> cb);

    @GET("/atms")
    void getATMs(@Query("key") String key, @Query("lat") Float latitude, @Query("lng") Float longitude, @Query("rad") Float radius,
        @Query("page") Integer page, Callback<PaginatedResponse<ATM>> cb);

    @GET("/atms/{id}")
    void getATM(@Query("key") String key, @Path("id") String id, Callback<ATM> cb);
}
