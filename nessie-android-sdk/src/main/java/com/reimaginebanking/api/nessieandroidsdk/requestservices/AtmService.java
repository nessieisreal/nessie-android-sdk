package com.reimaginebanking.api.nessieandroidsdk.requestservices;

import com.reimaginebanking.api.nessieandroidsdk.models.ATM;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * ATM endpoints
 */
public interface AtmService {
    @GET("/atms")
    void getATMs(@Query("key") String key, Callback<List<ATM>> cb);

    @GET("/atms/{id}")
    void getATM(@Query("key") String key, @Path("id") String id, Callback<ATM> cb);
}
